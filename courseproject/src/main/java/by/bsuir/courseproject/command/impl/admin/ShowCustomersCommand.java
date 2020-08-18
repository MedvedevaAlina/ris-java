package by.bsuir.courseproject.command.impl.admin;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.entity.Customer;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.impl.CustomerServiceImpl;
import by.bsuir.courseproject.util.constant.PageLocation;
import by.bsuir.courseproject.util.constant.ParameterName;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowCustomersCommand implements Command {
    private final static Logger logger = LogManager.getLogger(ShowCustomersCommand.class);

    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        CommandResultPage resultPage = new CommandResultPage();
        List<Customer> customers;
        try {
            customers = CustomerServiceImpl.getInstance().findAll();
            request.setAttribute(ParameterName.CUSTOMERS, customers);
            resultPage.setPage(PageLocation.CUSTOMERS_PAGE);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
        }
        return resultPage;
    }
}
