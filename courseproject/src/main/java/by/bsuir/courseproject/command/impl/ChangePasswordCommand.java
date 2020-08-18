package by.bsuir.courseproject.command.impl;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.entity.RoleType;
import by.bsuir.courseproject.entity.User;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.UserService;
import by.bsuir.courseproject.service.impl.UserServiceImpl;
import by.bsuir.courseproject.util.MessageManager;
import by.bsuir.courseproject.util.constant.PageLocation;
import by.bsuir.courseproject.util.constant.ParameterName;
import by.bsuir.courseproject.validator.DataValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ChangePasswordCommand implements Command {
    private final static Logger logger = LogManager.getLogger(ChangePasswordCommand.class);

    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        CommandResultPage resultPage = new CommandResultPage();
        User user = (User)request.getSession().getAttribute(RoleType.USER);
        String lastPassword = request.getParameter(ParameterName.LAST_PASSWORD);
        String newPassword = request.getParameter(ParameterName.NEW_PASSWORD);
        String repeatPassword = request.getParameter("repeatNewPassword");

        if(!newPassword.equals(repeatPassword)){
            request.setAttribute("errorChangePass", "Повторите пароль корректно!");
            resultPage.setPage(PageLocation.ADMIN_MAIN);
        }
        else {
            if (DataValidator.validatePassword(lastPassword, newPassword)) {
                try {
                    if (true) {
                        user.setPassword(newPassword);
                        UserServiceImpl.getInstance().update(user);
                        resultPage.setPage(PageLocation.ADMIN_MAIN);
                        request.setAttribute("errorChangePass", "Пароль успешно изменен!");
                        resultPage.setForward(false);
                    } else {
                        request.setAttribute("errorChangePass", MessageManager.getProperty("message.change.pass.error"));
                        resultPage.setPage(PageLocation.ADMIN_MAIN);
                    }
                } catch (ServiceException e) {
                    logger.log(Level.ERROR, " ChangePasswordCommand is failed!");
                }
            } else {
                request.setAttribute("errorChangePass", MessageManager.getProperty("message.change.pass.error"));
                resultPage.setPage(PageLocation.ADMIN_MAIN);
            }
        }
        //todo подумать насчет update vs. redirect
//        request.setAttribute("errorChangePass", MessageManager.getProperty("message.successful.change.pass"));
        return resultPage;
    }
}
