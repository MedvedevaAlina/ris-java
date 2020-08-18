package by.bsuir.courseproject.command.impl.admin;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.entity.Customer;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.impl.CustomerServiceImpl;
import by.bsuir.courseproject.util.MessageManager;
import by.bsuir.courseproject.util.constant.PageLocation;
import by.bsuir.courseproject.util.constant.ParameterName;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SearchCustomerCommand implements Command {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        CommandResultPage resultPage = new CommandResultPage();
        String sub = request.getParameter(ParameterName.SEARCH_CUSTOMER);
        List<Customer> customers;
        try {
            customers= CustomerServiceImpl.getInstance().search(sub);
            if(customers.isEmpty()){
                request.setAttribute("errorSearch", MessageManager.getProperty("message.empty.Data"));
                customers = CustomerServiceImpl.getInstance().findAll();
            }
            request.setAttribute(ParameterName.CUSTOMERS, customers);
            resultPage.setPage(PageLocation.CUSTOMERS_PAGE);
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, "Error in SearchCustomerCommand!");
        }
        return resultPage;
    }
}
