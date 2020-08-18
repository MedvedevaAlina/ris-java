package by.bsuir.courseproject.dao;

import by.bsuir.courseproject.entity.Orders;
import by.bsuir.courseproject.entity.Worker;

import java.util.List;

public interface OrdersDAO extends BaseDAO<Orders> {
    List<Orders> findAll() throws DAOException;
    Orders findById(int id) throws DAOException;
    List<Orders> search (long start, long end, String status, int id) throws DAOException;
}
