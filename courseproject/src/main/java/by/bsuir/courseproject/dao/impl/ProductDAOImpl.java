package by.bsuir.courseproject.dao.impl;

import by.bsuir.courseproject.dao.DAOException;
import by.bsuir.courseproject.dao.ProductDAO;
import by.bsuir.courseproject.entity.Product;
import by.bsuir.courseproject.util.HibernateSessionFactoryUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private static Logger logger = LogManager.getLogger();
    @Override
    public List<Product> findAll() throws DAOException {
        List<Product> products;
        try{
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            products = session.createQuery("From Product ").list();
            session.close();
        }catch (Exception e) {
            logger.error("Can't get all orders from Orders table", e);
            throw new DAOException(e);
        }
        return products;
    }

    @Override
    public boolean update(Product product) throws DAOException {
        return false;
    }

    @Override
    public int add(Product product) throws DAOException {
        return 0;
    }
}
