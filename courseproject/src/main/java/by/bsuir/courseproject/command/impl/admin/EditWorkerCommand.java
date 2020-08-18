package by.bsuir.courseproject.command.impl.admin;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.entity.User;
import by.bsuir.courseproject.entity.Worker;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.impl.WorkerServiceImpl;
import by.bsuir.courseproject.util.MessageManager;
import by.bsuir.courseproject.util.constant.PageLocation;
import by.bsuir.courseproject.util.constant.ParameterName;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EditWorkerCommand implements Command {
    private final static Logger logger = LogManager.getLogger(EditWorkerCommand.class);

    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        CommandResultPage resultPage = new CommandResultPage();
        Worker worker = createWorker(request);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(ParameterName.USER_WORKER);
        String status = request.getParameter("status");
        user.setStatus(status);
        worker.setUser(user);
        if (worker != null) {
            try {
                if (WorkerServiceImpl.getInstance().update(worker)) {
                    session.removeAttribute(ParameterName.USER_WORKER);
                    session.removeAttribute(ParameterName.WORKER);
                    request.getSession().setAttribute(ParameterName.WORKERS, WorkerServiceImpl.getInstance().findAll());
                    resultPage.setPage(PageLocation.WORKERS_PAGE);
                    resultPage.setForward(false);
                } else {
                    resultPage.setPage(PageLocation.WORKERS_PAGE);
                    request.setAttribute("resultChangeWorkers", MessageManager.getProperty("message.failed.add"));
                }
            } catch (ServiceException e) {
                logger.log(Level.ERROR, "Error in EditWorkerCommand!");
            }
        } else {
            resultPage.setPage(PageLocation.WORKERS_PAGE);
            request.setAttribute("resultChangeWorkers", MessageManager.getProperty("message.failed.add"));
        }
        return resultPage;
    }

    private Worker createWorker(HttpServletRequest request){
        String id = request.getParameter(ParameterName.ID_WORKER);
        int idWorker = Integer.valueOf(id);
        String surname=request.getParameter("surname");
        String name=request.getParameter("name");
        String seniority =request.getParameter("seniority");
        double senior = Double.valueOf(seniority);
        String phone =request.getParameter("phone");
        String region =request.getParameter("region");
        return new Worker(idWorker, surname, name, senior, phone,region);
    }
}
