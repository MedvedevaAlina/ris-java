package by.bsuir.courseproject.command.impl;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.entity.Product;
import by.bsuir.courseproject.entity.RoleType;
import by.bsuir.courseproject.entity.User;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.impl.ProductServiceImpl;
import by.bsuir.courseproject.service.impl.UserServiceImpl;
import by.bsuir.courseproject.util.constant.AttributeName;
import by.bsuir.courseproject.util.MessageManager;
import by.bsuir.courseproject.util.constant.PageLocation;
import by.bsuir.courseproject.util.constant.ParameterName;
import by.bsuir.courseproject.validator.DataValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;


public class LoginCommand implements Command {
    private static  Logger logger= LogManager.getLogger();

    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        CommandResultPage resultPage = new CommandResultPage();
        String login = request.getParameter(ParameterName.LOGIN);
        String password = request.getParameter(ParameterName.PASSWORD);


        if(DataValidator.validateLoginPassword(login,password)) {

            try {
                Optional<User> optionalUser= UserServiceImpl.getInstance().findUserByLoginPassword(login, password);
                if (optionalUser.isPresent()) {
                    User user = optionalUser.get();
                    if (user.getStatus().equals(ParameterName.BLOCKED_STATUS)) {
                        request.setAttribute("errorAuthorisation",   MessageManager.getProperty("message.blocked.account"));
                        resultPage.setPage(PageLocation.MAIN_PAGE);
                    } else {
                        session.setAttribute(AttributeName.LOGIN, login);
                        session.setAttribute(AttributeName.PASSWORD, password);
                        session.setAttribute(AttributeName.USER, user);
                        switch (user.getRole()) {
                            case RoleType.ADMIN:
                                session.setAttribute(AttributeName.ROLE, AttributeName.ADMIN);
                                resultPage.setPage(PageLocation.ADMIN_MAIN);
                                break;
                            case RoleType.CUSTOMER:
                                session.setAttribute(AttributeName.ROLE, AttributeName.CUSTOMER);
                                resultPage.setPage(PageLocation.CUSTOMER_MAIN);
                                session.setAttribute(AttributeName.CUSTOMER, user.getCustomer());
                                break;
                            case RoleType.WORKER:
                                session.setAttribute(AttributeName.ROLE, AttributeName.WORKER);
                                resultPage.setPage(PageLocation.WORKER_MAIN);
                                session.setAttribute(AttributeName.WORKER, user.getWorker());
                                break;
                        }

                        return resultPage;
                    }
                } else {
                    request.setAttribute("errorAuthorisation", MessageManager.getProperty("message.login.error"));
                    resultPage.setPage(PageLocation.MAIN_PAGE);
                }
            } catch (ServiceException e) {
                logger.error("Error in LoginCommand! ", e);
                throw new CommandException(e);
            }
        } else {
            request.setAttribute("errorAuthorisation",   MessageManager.getProperty("message.login.error"));
            resultPage.setPage(PageLocation.MAIN_PAGE);
        }
        return resultPage;
    }
}
