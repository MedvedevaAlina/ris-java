package by.bsuir.courseproject.service.impl;

import by.bsuir.courseproject.dao.DAOException;
import by.bsuir.courseproject.dao.ProductDAO;
import by.bsuir.courseproject.dao.factory.DAOFactory;
import by.bsuir.courseproject.entity.Product;
import by.bsuir.courseproject.service.ProductService;
import by.bsuir.courseproject.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ProductServiceImpl implements ProductService<Product> {
    private static Logger logger = LogManager.getLogger();
    private final static ProductServiceImpl instance= new ProductServiceImpl();
    private ProductDAO productDAO = DAOFactory.getInstance().getProductDAO();


    private ProductServiceImpl() {  }

    public static ProductServiceImpl getInstance() {
        return instance;
    }

    @Override
    public List<Product> findAll() throws ServiceException {
        try {
            return productDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public long save(Product item) throws ServiceException {
        return 0;
    }

    @Override
    public Product find(int id) throws ServiceException {
        return null;
    }

    @Override
    public boolean update(Product item) throws ServiceException {
        return false;
    }

    @Override
    public List<Product> searchBySurname(String surname) throws ServiceException {
        return null;
    }
}
