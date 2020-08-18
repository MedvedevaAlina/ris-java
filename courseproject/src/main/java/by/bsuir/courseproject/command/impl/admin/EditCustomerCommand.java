package by.bsuir.courseproject.command.impl.admin;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.entity.Customer;
import by.bsuir.courseproject.entity.User;
import by.bsuir.courseproject.entity.Worker;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.impl.CustomerServiceImpl;
import by.bsuir.courseproject.service.impl.WorkerServiceImpl;
import by.bsuir.courseproject.util.MessageManager;
import by.bsuir.courseproject.util.constant.PageLocation;
import by.bsuir.courseproject.util.constant.ParameterName;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EditCustomerCommand implements Command {
    private final static Logger logger = LogManager.getLogger(EditCustomerCommand.class);

    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        CommandResultPage resultPage = new CommandResultPage();
        Customer customer = initCustomer(request);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(ParameterName.USER_CUSTOMER);
        String status = request.getParameter("status");
        user.setStatus(status);
        customer.setUser(user);
        if (customer != null) {
            try {
                if (CustomerServiceImpl.getInstance().update(customer)) {
                    session.removeAttribute(ParameterName.USER_CUSTOMER);
                    session.removeAttribute(ParameterName.CUSTOMER);
                    request.getSession().setAttribute(ParameterName.CUSTOMERS, CustomerServiceImpl.getInstance().findAll());
                    resultPage.setPage(PageLocation.CUSTOMERS_PAGE);
                    resultPage.setForward(false);
                } else {
                    resultPage.setPage(PageLocation.CUSTOMERS_PAGE);
                    request.setAttribute("resultChangeCustomers", MessageManager.getProperty("message.failed.add"));
                }
            } catch (ServiceException e) {
                logger.log(Level.ERROR, "Error in EditWorkerCommand!");
            }
        } else {
            resultPage.setPage(PageLocation.CUSTOMERS_PAGE);
            request.setAttribute("resultChangeCustomers", MessageManager.getProperty("message.failed.add"));
        }
        return resultPage;
    }

    private Customer initCustomer(HttpServletRequest request){
        String id = request.getParameter(ParameterName.ID_CUSTOMER);
        int idCustomer = Integer.valueOf(id);
        String name=request.getParameter("customer_name");
        String representative =request.getParameter("representative");
        String email =request.getParameter("email");
        String region =request.getParameter("region");
        return  new Customer(idCustomer, name, representative, email, region);
    }
}
