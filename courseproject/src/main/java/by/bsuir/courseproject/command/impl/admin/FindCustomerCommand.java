package by.bsuir.courseproject.command.impl.admin;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.entity.Customer;
import by.bsuir.courseproject.entity.Worker;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.impl.CustomerServiceImpl;
import by.bsuir.courseproject.service.impl.WorkerServiceImpl;
import by.bsuir.courseproject.util.constant.PageLocation;
import by.bsuir.courseproject.util.constant.ParameterName;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class FindCustomerCommand implements Command {
    private final static Logger logger = LogManager.getLogger(FindCustomerCommand.class);

    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        CommandResultPage resultPage = new CommandResultPage();
        int idCustomer = Integer.parseInt(request.getParameter(ParameterName.ID));
        try {
            Customer customer = CustomerServiceImpl.getInstance().find(idCustomer);
            request.getSession().setAttribute(ParameterName.CUSTOMER, customer);
            resultPage.setPage(PageLocation.EDIT_CUSTOMER_PAGE);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Error in FindCustomerCommand!");
        }
        return resultPage;
    }
}
