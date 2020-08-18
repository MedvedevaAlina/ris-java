package by.bsuir.courseproject.service;

import java.util.List;

public interface CustomerService<T> {
    List<T> findAll() throws ServiceException;
    long save(T item) throws ServiceException;
    T find(int id)throws ServiceException;
    boolean update(T item) throws ServiceException;

    List<T> search(String name) throws ServiceException;

}
