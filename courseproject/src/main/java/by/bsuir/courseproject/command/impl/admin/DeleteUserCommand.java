package by.bsuir.courseproject.command.impl.admin;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.impl.CustomerServiceImpl;
import by.bsuir.courseproject.service.impl.UserServiceImpl;
import by.bsuir.courseproject.service.impl.WorkerServiceImpl;
import by.bsuir.courseproject.util.constant.PageLocation;
import by.bsuir.courseproject.util.constant.ParameterName;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class DeleteUserCommand implements Command {
    private final static Logger logger = LogManager.getLogger(DeleteUserCommand.class);

    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        CommandResultPage resultPage = new CommandResultPage();
        String id = request.getParameter(ParameterName.ID);
        String page = request.getParameter(ParameterName.PAGE);
        int idUser = Integer.valueOf(id);
        try {
            if (UserServiceImpl.getInstance().delete(idUser)) {
                resultPage.setPage(page);
                request.getSession().setAttribute(ParameterName.WORKERS, WorkerServiceImpl.getInstance().findAll());
                request.getSession().setAttribute(ParameterName.CUSTOMERS, CustomerServiceImpl.getInstance().findAll());
            }
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Error in DeleteUserCommand!");
        }
        resultPage.setPage(page);
        return resultPage;
    }
}
