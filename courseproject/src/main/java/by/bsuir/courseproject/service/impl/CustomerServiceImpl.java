package by.bsuir.courseproject.service.impl;

import by.bsuir.courseproject.dao.CustomerDAO;
import by.bsuir.courseproject.dao.DAOException;
import by.bsuir.courseproject.dao.WorkerDAO;
import by.bsuir.courseproject.dao.factory.DAOFactory;
import by.bsuir.courseproject.entity.Customer;
import by.bsuir.courseproject.service.CustomerService;
import by.bsuir.courseproject.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomerServiceImpl implements CustomerService<Customer> {
    private static Logger logger = LogManager.getLogger();
    private final static CustomerServiceImpl instance= new CustomerServiceImpl();
    private CustomerDAO customerDAO = DAOFactory.getInstance().getCustomerDAO();


    private CustomerServiceImpl() {  }

    public static CustomerServiceImpl getInstance() {
        return instance;
    }

    @Override
    public List<Customer> findAll() throws ServiceException {
        try {
            return customerDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public long save(Customer item) throws ServiceException {
        try {
            return customerDAO.add(item);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Customer> search(String name) throws ServiceException {
        try {
            return customerDAO.search(name);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean update(Customer item) throws ServiceException {
        try {
            return customerDAO.update(item);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Customer find(int id) throws ServiceException {
        try {
            return customerDAO.findById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
