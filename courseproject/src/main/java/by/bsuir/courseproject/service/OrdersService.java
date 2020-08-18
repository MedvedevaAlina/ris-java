package by.bsuir.courseproject.service;

import java.util.List;

public interface OrdersService<T> {
    List<T> findAll() throws ServiceException;
    T find(int id) throws ServiceException;
    boolean update(T item) throws ServiceException;

    List<T> search(long start, long end, String status, int id) throws ServiceException;
}
