package by.bsuir.courseproject.command.impl.admin;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.entity.User;
import by.bsuir.courseproject.entity.Worker;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.impl.UserServiceImpl;
import by.bsuir.courseproject.service.impl.WorkerServiceImpl;
import by.bsuir.courseproject.util.MessageManager;
import by.bsuir.courseproject.util.constant.AttributeName;
import by.bsuir.courseproject.util.constant.PageLocation;
import by.bsuir.courseproject.util.constant.ParameterName;
import by.bsuir.courseproject.util.generator.GeneratorLogin;
import by.bsuir.courseproject.util.generator.GeneratorPassword;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class AddWorkerCommand implements Command {
    private final static Logger logger = LogManager.getLogger(AddWorkerCommand.class);

    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        CommandResultPage resultPage = new CommandResultPage();
        Worker worker;
        worker = initWorker(request);
        if(worker!=null){
            try {
                User user = new User(GeneratorLogin.generateLogin(),GeneratorPassword.generatePassword(),"worker");
                int idUser=UserServiceImpl.getInstance().save(user);
                if(idUser>0){
                    user.setIdUser(idUser);
                    worker.setUser(user);
                    WorkerServiceImpl.getInstance().save(worker);
                    request.getSession().setAttribute(ParameterName.WORKERS, WorkerServiceImpl.getInstance().findAll());
                    resultPage.setPage(PageLocation.WORKERS_PAGE);
                    resultPage.setForward(false);
                    request.setAttribute(AttributeName.RESULT_CHANGE_WORKERS, MessageManager.getProperty("message.successful.add"));
                } else{
                    resultPage.setPage(PageLocation.WORKERS_PAGE);
                    request.setAttribute(AttributeName.RESULT_CHANGE_WORKERS, MessageManager.getProperty("message.failed.add"));
                }
            } catch (ServiceException e) {
                logger.log(Level.ERROR, " Error in AddWorkerCommand!");
            }
        }else {
            resultPage.setPage(PageLocation.WORKERS_PAGE);
            request.setAttribute(AttributeName.RESULT_CHANGE_WORKERS, MessageManager.getProperty("message.failed.add"));
        }
        return resultPage;
    }

    private Worker initWorker(HttpServletRequest request) {
        String surname=request.getParameter(ParameterName.SURNAME);
        String name=request.getParameter(ParameterName.NAME);
        String seniority =request.getParameter(ParameterName.SENIORITY);
        double senior = Double.valueOf(seniority);
        String phone =request.getParameter(ParameterName.PHONE);
        String region =request.getParameter(ParameterName.REGION);
        Worker worker = new Worker(surname, name, senior, phone,region);
        return worker;
    }
}
