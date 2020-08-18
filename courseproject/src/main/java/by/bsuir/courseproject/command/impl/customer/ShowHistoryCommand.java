package by.bsuir.courseproject.command.impl.customer;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.entity.Customer;
import by.bsuir.courseproject.entity.Orders;
import by.bsuir.courseproject.util.constant.PageLocation;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

public class ShowHistoryCommand implements Command {
    private final static Logger logger = LogManager.getLogger(ShowHistoryCommand.class);

    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        CommandResultPage resultPage = new CommandResultPage();
        Customer customer = (Customer) request.getSession().getAttribute("customer");

        List<Orders> orders;
        if(customer!=null){

            orders = customer.getOrders();
            Collections.reverse(orders);
            request.setAttribute("orders", orders);
            resultPage.setPage(PageLocation.HISTORY_PAGE);
        }
        return resultPage;
    }
}
