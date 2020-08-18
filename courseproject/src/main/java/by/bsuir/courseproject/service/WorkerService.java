package by.bsuir.courseproject.service;

import java.util.List;

public interface WorkerService<T> {
    List<T> findAll() throws ServiceException;
    long save(T item) throws ServiceException;
    T find(int id)throws ServiceException;
    boolean update(T item) throws ServiceException;
    List<T> searchBySurname(String surname) throws ServiceException;
}
