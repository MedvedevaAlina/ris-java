package by.bsuir.courseproject.dao.impl;

import by.bsuir.courseproject.dao.CustomerDAO;
import by.bsuir.courseproject.dao.DAOException;
import by.bsuir.courseproject.dao.WorkerDAO;
import by.bsuir.courseproject.entity.Customer;
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

public class CustomerDAOImpl implements CustomerDAO {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean update(Customer user) throws DAOException {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
            session.close();
        }catch (Exception e) {
            logger.error("Can't update customer", e);
            throw new DAOException(e);
        }
        return true;
    }

    @Override
    public int add(Customer customer) throws DAOException {
        int id =-1;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            id = (Integer)session.save(customer);
            transaction.commit();
            session.close();
        }catch (Exception e) {
            logger.error("Can't insert customer", e);
            throw new DAOException(e);
        }
        return id;
    }

    @Override
    public List<Customer> findAll() throws DAOException {
        List<Customer> customers;
        try{
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        customers = session.createQuery("From Customer ").list();
        session.close();
        }catch (Exception e) {
            logger.error("Can't get all customers from Customer table", e);
            throw new DAOException(e);
         }
        return customers;
    }

    @Override
    public List<Customer> search(String name) throws DAOException {
        List<Customer> list;
        List<Customer> li;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Criteria query = session.createCriteria(Customer.class);
            list = query.add(Restrictions.like("name", name, MatchMode.ANYWHERE)).list();
            Criteria query1 = session.createCriteria(Customer.class);
            li = query1.add(Restrictions.like("representative", name, MatchMode.ANYWHERE)).list();
            list.addAll(li);
            session.close();
        }catch (Exception e) {
            logger.error("Can't search customer from Customer table by start name", e);
            throw new DAOException(e);
        }
        return list;
    }

    @Override
    public Customer findById(int id) throws DAOException {
        List<Customer> list;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Customer where idCustomer = :paramName");
            query.setParameter("paramName", id);
            list = query.list();
            session.close();
        } catch (Exception e) {
            logger.error("Can't get customer from Customer table by id", e);
            throw new DAOException(e);
        }
        return list.get(0);
    }
}
