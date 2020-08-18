package by.bsuir.courseproject.command.impl;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.util.constant.PageLocation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand  implements Command {
    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        HttpSession httpSession = request.getSession(false);
        if (httpSession != null){
            httpSession.invalidate();
        }
        CommandResultPage resultPage = new CommandResultPage(PageLocation.MAIN_PAGE, false);
        return resultPage;
    }
}
