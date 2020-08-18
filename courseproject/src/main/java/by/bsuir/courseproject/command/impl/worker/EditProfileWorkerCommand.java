package by.bsuir.courseproject.command.impl.worker;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.entity.Customer;
import by.bsuir.courseproject.entity.User;
import by.bsuir.courseproject.entity.Worker;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.impl.CustomerServiceImpl;
import by.bsuir.courseproject.service.impl.WorkerServiceImpl;
import by.bsuir.courseproject.util.MessageManager;
import by.bsuir.courseproject.util.constant.PageLocation;
import by.bsuir.courseproject.util.constant.ParameterName;
import by.bsuir.courseproject.validator.DataValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EditProfileWorkerCommand implements Command {
    private final static Logger logger = LogManager.getLogger(EditProfileWorkerCommand.class);

    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        CommandResultPage resultPage = new CommandResultPage();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user_worker");

        Worker worker = (Worker) session.getAttribute(ParameterName.WORKER);
        initWorker(request, worker);
        String login = request.getParameter("login");
        user.setLogin(login);
        String lastPassword = request.getParameter(ParameterName.LAST_PASSWORD);
        String newPassword = request.getParameter(ParameterName.NEW_PASSWORD);

        if (DataValidator.validatePassword(lastPassword, newPassword)) {
                if (user.getPassword().equals(lastPassword)) {
                    user.setPassword(newPassword);
                } else {
                    request.setAttribute("errorEditWorker", MessageManager.getProperty("message.change.pass.error"));
                    resultPage.setPage(PageLocation.WORKER_MAIN);
                }
        }

        worker.setUser(user);
        if (worker != null) {
            try {
                if (WorkerServiceImpl.getInstance().update(worker)) {
                    resultPage.setPage(PageLocation.WORKER_MAIN);
                    resultPage.setForward(false);
                } else {
                    resultPage.setPage(PageLocation.WORKER_MAIN);
                    request.setAttribute("errorEditWorker", MessageManager.getProperty("message.failed.edit"));
                }
            } catch (ServiceException e) {
                logger.log(Level.ERROR, "Error in EditWorkerCommand!");
            }
        } else {
            resultPage.setPage(PageLocation.WORKER_MAIN);
            request.setAttribute("errorEditCustomer", MessageManager.getProperty("message.failed.edit"));
        }
        return resultPage;
    }

    private void initWorker(HttpServletRequest request, Worker worker){

        String surname=request.getParameter("surname");
        worker.setSurname(surname);
        String name =request.getParameter("name");
        worker.setName(name);
        String phone =request.getParameter("phone");
        worker.setPhone(phone);
        String region =request.getParameter("region");
        worker.setRegionWorker(region);
    }
}
