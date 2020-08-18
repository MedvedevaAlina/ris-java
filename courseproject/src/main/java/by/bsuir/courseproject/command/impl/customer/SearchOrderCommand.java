package by.bsuir.courseproject.command.impl.customer;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.entity.Customer;
import by.bsuir.courseproject.entity.Orders;
import by.bsuir.courseproject.entity.Worker;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.impl.OrdersServiceImpl;
import by.bsuir.courseproject.service.impl.WorkerServiceImpl;
import by.bsuir.courseproject.util.MessageManager;
import by.bsuir.courseproject.util.constant.PageLocation;
import by.bsuir.courseproject.util.constant.ParameterName;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SearchOrderCommand implements Command {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        CommandResultPage resultPage = new CommandResultPage();
        String start = request.getParameter("search-order-from");
        String end = request.getParameter("search-order-since");
        String status = request.getParameter("status");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

        Customer cust = (Customer)request.getSession().getAttribute("customer");
        int id = cust.getIdCustomer();
        List<Orders> orders ;
        try {

            Date date_start = formatter.parse(start);
            Date dateEnd = formatter.parse(end);
            orders= OrdersServiceImpl.getInstance().search(date_start.getTime(), dateEnd.getTime(),status, id);
            if(orders.isEmpty()){
                request.setAttribute("errorSearch", MessageManager.getProperty("message.empty.Data"));
                orders =  cust.getOrders();
            }
            request.setAttribute("orders", orders);
            resultPage.setPage(PageLocation.HISTORY_PAGE);
        } catch (ServiceException e ) {
            LOGGER.log(Level.ERROR, "Error in SearchWorkerCommand!");
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return resultPage;
    }
}
