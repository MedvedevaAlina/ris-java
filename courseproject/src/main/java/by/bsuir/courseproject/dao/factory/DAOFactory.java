package by.bsuir.courseproject.dao.factory;

import by.bsuir.courseproject.dao.*;
import by.bsuir.courseproject.dao.impl.*;

public class DAOFactory {
    private final static DAOFactory instance = new DAOFactory();

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    public WorkerDAO getWorkerDAO() {
        return new WorkerDAOImpl();
    }
    public CustomerDAO getCustomerDAO() {
        return new CustomerDAOImpl();
    }

    public OrdersDAO getOrdersDAO() {
        return new OrdersDAOImpl();
    }

    public WarehouseProductDAO getWarehouseProductDAO() {
        return new WarehouseProductDAOImpl();
    }
    public  ProductDAO getProductDAO() { return new ProductDAOImpl();}
}
