package by.bsuir.courseproject.service;

import by.bsuir.courseproject.dao.DAOException;

import java.util.List;
import java.util.Optional;

public interface UserService<T> {

    List<T> findAll() throws ServiceException;

    int save(T item) throws ServiceException;

    boolean update(T item) throws ServiceException;

    boolean delete(int id) throws ServiceException;

//    boolean updatePassword(long id, String pass) throws ServiceException;
}
