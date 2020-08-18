package by.bsuir.courseproject.command.impl.customer;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.entity.Customer;
import by.bsuir.courseproject.util.constant.ParameterName;

import javax.servlet.http.HttpServletRequest;

public class SubmitOrderCommand implements Command {
    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        CommandResultPage resultPage = new CommandResultPage();
        Customer customer = (Customer) request.getSession().getAttribute(ParameterName.CUSTOMER);
        resultPage.setPage("/jsp/customer/orderData.jsp");
        String[] mas =customer.getRepresentative().split(" ");
        request.setAttribute("surname", mas[0]);
        request.setAttribute("name", mas[1]);
        request.setAttribute("last_name", mas[2]);
        request.setAttribute("email", customer.getEmail());
        request.setAttribute("last_name", mas[2]);
        request.setAttribute("last_name", mas[2]);
        request.setAttribute("last_name", mas[2]);
        return resultPage;
    }
}
