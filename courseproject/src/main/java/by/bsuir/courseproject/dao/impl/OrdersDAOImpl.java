package by.bsuir.courseproject.dao.impl;

import by.bsuir.courseproject.dao.DAOException;
import by.bsuir.courseproject.dao.OrdersDAO;
import by.bsuir.courseproject.entity.Orders;
import by.bsuir.courseproject.entity.Worker;
import by.bsuir.courseproject.util.HibernateSessionFactoryUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;

public class OrdersDAOImpl implements OrdersDAO {

    private static Logger logger = LogManager.getLogger();

    @Override
    public int add(Orders orders) throws DAOException {
        return 0;
    }

    @Override
    public boolean update(Orders orders) throws DAOException {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(orders);
            transaction.commit();
            session.close();
        }catch (Exception e) {
            logger.error("Can't update order", e);
            throw new DAOException(e);
        }
        return true;
    }

    @Override
    public Orders findById(int id) throws DAOException {
        List<Orders> list;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Orders where idOrder = :paramName");
            query.setParameter("paramName", id);
            list = query.list();
            session.close();
        } catch (Exception e) {
            logger.error("Can't get order from Order table by id", e);
            throw new DAOException(e);
        }
        return list.get(0);
    }

    @Override
    public List<Orders> search(long start, long end, String status, int id) throws DAOException {
        List<Orders> list;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Orders where orderDate > :paramStart and orderDate < :paramEnd and processing = :paramStatus and customer.idCustomer = :paramID");
            query.setParameter("paramStart", start);
            query.setParameter("paramEnd", end);
            query.setParameter("paramStatus", status);
            query.setParameter("paramID", id);
            list = query.list();
        }catch (Exception e) {
            logger.error("Can't search worker from Worker table by start surname", e);
            throw new DAOException(e);
        }
        return list;
    }

    @Override
    public List<Orders> findAll() throws DAOException {
        List<Orders> orders;
        try{
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            orders = session.createQuery("From Orders ").list();
            session.close();
        }catch (Exception e) {
            logger.error("Can't get all orders from Orders table", e);
            throw new DAOException(e);
        }
        return orders;
    }
}
