package by.bsuir.courseproject.controller;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandFactory;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.util.HibernateSessionFactoryUtil;
import by.bsuir.courseproject.util.constant.PageLocation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class LogisticsController extends HttpServlet {
    private static final String COMMAND = "command";
    private static final String ERROR = "error";

    @Override
    public void init() throws ServletException {
        super.init();
        HibernateSessionFactoryUtil.getSessionFactory();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter(COMMAND);

        Command action;
        CommandResultPage commandResult;
        try {
            action = CommandFactory.define(command);//switch commands/ return my command
            commandResult = action.execute(request);
        } catch (CommandException e) {
            //fixme
            commandResult  = new CommandResultPage(PageLocation.PAGE_NOT_FOUND, false);
            request.getSession().setAttribute(ERROR, e);
        }

        String page = commandResult.getPage();
        if (commandResult.isForward()) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(page);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        HibernateSessionFactoryUtil.closeFactory();
    }
}
