package by.bsuir.courseproject.command.impl;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.util.constant.ParameterName;

import javax.servlet.http.HttpServletRequest;

public class LoadPageCommand implements Command {
    @Override
    public CommandResultPage execute(HttpServletRequest request) {
        CommandResultPage resultPage = new CommandResultPage(request.getParameter(ParameterName.PAGE));
        return resultPage;
    }
}