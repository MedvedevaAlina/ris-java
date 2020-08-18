package by.bsuir.courseproject.service.impl;

import by.bsuir.courseproject.dao.DAOException;
import by.bsuir.courseproject.dao.UserDAO;
import by.bsuir.courseproject.dao.factory.DAOFactory;
import by.bsuir.courseproject.entity.User;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService<User> {
    private static Logger logger = LogManager.getLogger();
    private final static UserServiceImpl instance= new UserServiceImpl();
    private UserDAO userDAO = DAOFactory.getInstance().getUserDAO();


    private UserServiceImpl() {  }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    public Optional<User> findUserByLoginPassword(String login, String password) throws ServiceException {
        try {
            return userDAO.findUserByLoginPassword(login,password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> findAll() throws ServiceException {
        return null;
    }

    @Override
    public int save(User item) throws ServiceException {
        try {
            return userDAO.add(item);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean delete(int id) throws ServiceException {
        try {
            return userDAO.delete(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean update(User user) throws ServiceException {
        try {
            return userDAO.update(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
