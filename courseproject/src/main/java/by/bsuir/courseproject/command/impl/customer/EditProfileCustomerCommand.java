package by.bsuir.courseproject.command.impl.customer;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.command.impl.ChangePasswordCommand;
import by.bsuir.courseproject.entity.Customer;
import by.bsuir.courseproject.entity.User;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.impl.CustomerServiceImpl;
import by.bsuir.courseproject.service.impl.UserServiceImpl;
import by.bsuir.courseproject.util.MessageManager;
import by.bsuir.courseproject.util.constant.PageLocation;
import by.bsuir.courseproject.util.constant.ParameterName;
import by.bsuir.courseproject.validator.DataValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EditProfileCustomerCommand implements Command {
    private final static Logger logger = LogManager.getLogger(EditProfileCustomerCommand.class);

    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        CommandResultPage resultPage = new CommandResultPage();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(ParameterName.USER_CUSTOMER);

        Customer customer = (Customer) session.getAttribute(ParameterName.CUSTOMER);
        initCustomer(request, customer);
        String login = request.getParameter("login");
        user.setLogin(login);
        String lastPassword = request.getParameter(ParameterName.LAST_PASSWORD);
        String newPassword = request.getParameter(ParameterName.NEW_PASSWORD);

        if (DataValidator.validatePassword(lastPassword, newPassword)) {
                if (user.getPassword().equals(lastPassword)) {
                    user.setPassword(newPassword);
                } else {
                    request.setAttribute("errorEditCustomer", MessageManager.getProperty("message.change.pass.error"));
                    resultPage.setPage(PageLocation.CUSTOMER_MAIN);
                }
        }

        customer.setUser(user);
        if (customer != null) {
            try {
                if (CustomerServiceImpl.getInstance().update(customer)) {
                    resultPage.setPage(PageLocation.CUSTOMER_MAIN);
                    resultPage.setForward(false);
                } else {
                    resultPage.setPage(PageLocation.CUSTOMER_MAIN);
                    request.setAttribute("errorEditCustomer", MessageManager.getProperty("message.failed.edit"));
                }
            } catch (ServiceException e) {
                logger.log(Level.ERROR, "Error in EditWorkerCommand!");
            }
        } else {
            resultPage.setPage(PageLocation.CUSTOMER_MAIN);
            request.setAttribute("errorEditCustomer", MessageManager.getProperty("message.failed.edit"));
        }
        return resultPage;
    }

    private void initCustomer(HttpServletRequest request, Customer customer){

        String name=request.getParameter("customer_name");
        customer.setName(name);
        String representative =request.getParameter("representative");
        customer.setRepresentative(representative);
        String email =request.getParameter("email");
        customer.setEmail(email);
        String region =request.getParameter("region");
        customer.setRegionCustomer(region);
    }
}
