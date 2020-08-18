package by.bsuir.courseproject.command.impl.admin;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.entity.Customer;
import by.bsuir.courseproject.entity.User;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.impl.CustomerServiceImpl;
import by.bsuir.courseproject.util.MessageManager;
import by.bsuir.courseproject.util.constant.AttributeName;
import by.bsuir.courseproject.util.constant.PageLocation;
import by.bsuir.courseproject.util.constant.ParameterName;
import by.bsuir.courseproject.util.generator.GeneratorLogin;
import by.bsuir.courseproject.util.generator.GeneratorPassword;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class AddCustomerCommand implements Command {
    private final static Logger logger = LogManager.getLogger(AddCustomerCommand.class);

    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        CommandResultPage resultPage = new CommandResultPage();
        Customer customer;
        customer = initCustomer(request);
        if(customer!=null){
            try {
                User user = new User(GeneratorLogin.generateLogin(),GeneratorPassword.generatePassword(),"customer");
                //int idUser=UserServiceImpl.getInstance().save(user);
                int idUser=9;
                if(idUser>0){
                   // user.setIdUser(idUser);
                    customer.setUser(user);
                    CustomerServiceImpl.getInstance().save(customer);
                    request.getSession().setAttribute(ParameterName.CUSTOMERS, CustomerServiceImpl.getInstance().findAll());
                    resultPage.setPage(PageLocation.CUSTOMERS_PAGE);
                    //fixme
                    resultPage.setForward(false);
                    request.setAttribute(AttributeName.RESULT_CHANGE_CUSTOMERS, MessageManager.getProperty("message.successful.add"));
                } else{
                    resultPage.setPage(PageLocation.CUSTOMERS_PAGE);
                    request.setAttribute(AttributeName.RESULT_CHANGE_CUSTOMERS, MessageManager.getProperty("message.failed.add"));
                }
            } catch (ServiceException e) {
                logger.log(Level.ERROR, " Error in AddWorkerCommand!");
                resultPage.setPage(PageLocation.CUSTOMERS_PAGE);
                request.setAttribute(AttributeName.RESULT_CHANGE_CUSTOMERS, MessageManager.getProperty("message.failed.add"));
            }
        }else {
            resultPage.setPage(PageLocation.CUSTOMERS_PAGE);
            request.setAttribute(AttributeName.RESULT_CHANGE_CUSTOMERS, MessageManager.getProperty("message.failed.add"));
        }
        return resultPage;
    }

    private Customer initCustomer(HttpServletRequest request) {

        String name=request.getParameter(ParameterName.CUSTOMER_NAME);
        String representative =request.getParameter(ParameterName.REPRESENTATIVE);
        String email =request.getParameter(ParameterName.EMAIL);
        String region =request.getParameter(ParameterName.REGION);
         return  new Customer(name, representative, email, region);
    }
}
