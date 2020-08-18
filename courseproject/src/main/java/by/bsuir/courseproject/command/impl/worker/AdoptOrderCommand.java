package by.bsuir.courseproject.command.impl.worker;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.command.impl.admin.FindWorkerCommand;
import by.bsuir.courseproject.entity.Orders;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.impl.OrdersServiceImpl;
import by.bsuir.courseproject.service.impl.WarehouseProductServiceImpl;
import by.bsuir.courseproject.util.MessageManager;
import by.bsuir.courseproject.util.constant.PageLocation;
import by.bsuir.courseproject.util.constant.ParameterName;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

public class AdoptOrderCommand implements Command {
    private final static Logger logger = LogManager.getLogger(FindWorkerCommand.class);

    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        CommandResultPage resultPage = new CommandResultPage();

        int idOrder = Integer.parseInt(request.getParameter("idAdoptedOrder"));
        try {
            Orders order = OrdersServiceImpl.getInstance().find(idOrder);

            resultPage.setPage(PageLocation.ADOPT_ORDERS);
            request.setAttribute("idAdoptedOrder", idOrder);

            List<Orders> orders = OrdersServiceImpl.getInstance().findAll();
            request.setAttribute(ParameterName.ORDERS, orders);

            request.setAttribute("checkedOrder", MessageManager.getProperty("message.adoptedOrder"));
            order.setProcessing("adopted");


            OrdersServiceImpl.getInstance().update(order);

        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Error in CheckOrderCommand!");
        }
        return resultPage;
    }
}
