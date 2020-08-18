package by.bsuir.courseproject.command.impl.admin;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.entity.OrderProduct;
import by.bsuir.courseproject.entity.Orders;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.impl.OrdersServiceImpl;
import by.bsuir.courseproject.service.impl.WarehouseProductServiceImpl;
import by.bsuir.courseproject.util.MessageManager;
import by.bsuir.courseproject.util.comparator.OrderProductComparator;
import by.bsuir.courseproject.util.constant.PageLocation;
import by.bsuir.courseproject.util.constant.ParameterName;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

public class CheckOrderCommand implements Command {
    private final static Logger logger = LogManager.getLogger(FindWorkerCommand.class);

    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        CommandResultPage resultPage = new CommandResultPage();

        int idOrder = Integer.parseInt(request.getParameter(ParameterName.ID_CHECKED_ORDER));
        try {
            Orders order = OrdersServiceImpl.getInstance().find(idOrder);
            Map<Integer, Integer> productsInOrder= order.getOrderProducts().stream()
                    .sorted(Comparator.comparing(item->item.getId().getProduct().getIdProduct()))
                    .collect(Collectors.toMap(item->item.getId().getProduct().getIdProduct(), item->item.getAmount(), (oldValue, newValue) -> oldValue, TreeMap::new));

            int idWarehouse = order.getWarehouse().getIdWarehouse();
            Map<Integer, Integer> suppliersInWarehouse = WarehouseProductServiceImpl.getInstance().findSuppliers(idWarehouse);

            resultPage.setPage(PageLocation.ORDERS_PAGE);
            request.setAttribute(ParameterName.ID_CHECKED_ORDER, idOrder);

            List<Orders> orders = OrdersServiceImpl.getInstance().findAll();
            request.setAttribute(ParameterName.ORDERS, orders);

            if (order.getOrderProducts().size()!=13) {
                request.setAttribute("checkedOrder", MessageManager.getProperty("message.checkedOrder"));
                order.setProcessing("processed");

            } else {
                request.setAttribute("unCheckedOrder", MessageManager.getProperty("message.unCheckedOrder"));
                order.setProcessing("rejected");
            }

            OrdersServiceImpl.getInstance().update(order);

        } catch (ServiceException e) {
            logger.log(Level.ERROR, "Error in CheckOrderCommand!");
        }
        return resultPage;
    }

    private boolean equalsMap( Map<Integer, Integer> mapInsklad,  Map<Integer, Integer> mapInOrder){
        Set<Map.Entry<Integer,Integer>> demoOrderSet = mapInOrder.entrySet();
        ArrayList<Map.Entry<Integer,Integer>> demoOrderList = new ArrayList<>(demoOrderSet);
        for (Map.Entry<Integer,Integer> entryOrder: demoOrderList) {
            if(mapInsklad.containsKey(entryOrder.getKey())){
                if(mapInsklad.get(entryOrder.getKey())<entryOrder.getValue()){
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
