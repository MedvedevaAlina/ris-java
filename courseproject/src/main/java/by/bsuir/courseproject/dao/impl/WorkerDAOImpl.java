package by.bsuir.courseproject.dao.impl;

import by.bsuir.courseproject.dao.DAOException;
import by.bsuir.courseproject.dao.WorkerDAO;
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

public class WorkerDAOImpl implements WorkerDAO {
    private static Logger logger = LogManager.getLogger();

    @Override
    public boolean update(Worker worker) throws DAOException {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(worker);
            transaction.commit();
            session.close();
        }catch (Exception e) {
            logger.error("Can't update worker", e);
            throw new DAOException(e);
        }
        return true;
    }

    @Override
    public int add(Worker worker) throws DAOException {
        int id =-1;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            id = (Integer)session.save(worker);
            transaction.commit();
            session.close();
        }catch (Exception e) {
            logger.error("Can't insert worker", e);
            throw new DAOException(e);
        }
        return id;
    }

    @Override
    public List<Worker> findAll() throws DAOException {
        List<Worker> workers;
        try{
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        workers = session.createQuery("From Worker ").list();
        session.close();
        }catch (Exception e) {
            logger.error("Can't get all workers from Worker table", e);
            throw new DAOException(e);
         }
        return workers;
    }

    @Override
    public List<Worker> searchBySurname(String surname) throws DAOException {
        List<Worker> list;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Criteria query = session.createCriteria(Worker.class);
            list = query.add(Restrictions.like("surname", surname, MatchMode.START)).list();
        }catch (Exception e) {
            logger.error("Can't search worker from Worker table by start surname", e);
            throw new DAOException(e);
        }
        return list;
    }

    @Override
    public Worker findById(int id) throws DAOException {
        List<Worker> list;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Worker where idWorker = :paramName");
            query.setParameter("paramName", id);
            list = query.list();
            session.close();
        } catch (Exception e) {
            logger.error("Can't get worker from Worker table by id", e);
            throw new DAOException(e);
        }
        return list.get(0);
    }
}
