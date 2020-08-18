package by.bsuir.courseproject.dao;

import by.bsuir.courseproject.entity.Customer;

import java.util.List;

public interface CustomerDAO extends BaseDAO<Customer> {
    List<Customer> findAll() throws DAOException;
    Customer findById(int id) throws DAOException;
    List<Customer> search(String search) throws DAOException;

}
