package by.bsuir.courseproject.service.impl;

import by.bsuir.courseproject.dao.DAOException;
import by.bsuir.courseproject.dao.OrdersDAO;
import by.bsuir.courseproject.dao.WorkerDAO;
import by.bsuir.courseproject.dao.factory.DAOFactory;
import by.bsuir.courseproject.entity.Orders;
import by.bsuir.courseproject.service.OrdersService;
import by.bsuir.courseproject.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class OrdersServiceImpl implements OrdersService<Orders> {
    private static Logger logger = LogManager.getLogger();
    private final static OrdersServiceImpl instance= new OrdersServiceImpl();
    private OrdersDAO ordersDAO = DAOFactory.getInstance().getOrdersDAO();

    @Override
    public List<Orders> search(long start, long end, String status, int id) throws ServiceException {
        try {

            return ordersDAO.search(start, end, status, id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    private OrdersServiceImpl() {  }

    public static OrdersServiceImpl getInstance() {
        return instance;
    }

    @Override
    public Orders find(int id) throws ServiceException {
        try {
            return ordersDAO.findById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean update(Orders item) throws ServiceException {
        try {
            return ordersDAO.update(item);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Orders> findAll() throws ServiceException {
        try {
            return ordersDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
