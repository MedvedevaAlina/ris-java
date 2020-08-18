package by.bsuir.courseproject.dao.impl;

import by.bsuir.courseproject.dao.DAOException;
import by.bsuir.courseproject.dao.UserDAO;
import by.bsuir.courseproject.entity.User;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.util.HibernateSessionFactoryUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {
    private static Logger logger = LogManager.getLogger();

    @Override
    public Optional<User> findUserByLoginPassword(String login, String password) throws DAOException {
        try {
            List<User> users;
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            users = session.createQuery("From User where login = '" + login + "' and password = '" + password + "' ").list();
            Optional<User> optionalUser = Optional.empty();
            if(users.size()!=0) {
                optionalUser = Optional.of(users.get(0));
            }
            session.close();
            return optionalUser;
        } catch (Exception e) {
            logger.error("Can't find user with login " + login + " and password "+ password, e);
            throw new DAOException(e);
        }
    }

    @Override
    public boolean update(User user) throws DAOException {
      try {
          Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
          Transaction transaction = session.beginTransaction();
          session.saveOrUpdate(user);
          transaction.commit();
          session.close();
      }catch (Exception e) {
          logger.error("Can't update user", e);
          throw new DAOException(e);
      }
      return true;
    }

    @Override
    public boolean delete(int id) throws DAOException {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();

            Query query = session.createQuery("update User set status = :nameParam where idUser = :nameCode");
            query.setParameter("nameCode", id);
            query.setParameter("nameParam", "blocked");
            int result = query.executeUpdate();
            tx.commit();
            session.close();
        }catch (Exception e) {
            logger.error("Can't fire user", e);
            throw new DAOException(e);
        }
        return true;
    }

    @Override
    public int add(User user) throws DAOException {
        int id =-1;
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            id = (Integer)session.save(user);
            session.close();
        }catch (Exception e) {
            logger.error("Can't insert user", e);
            throw new DAOException(e);
        }
        return id;
    }
}
