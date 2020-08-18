package by.bsuir.courseproject.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    CommandResultPage execute(HttpServletRequest request) throws CommandException;
}
