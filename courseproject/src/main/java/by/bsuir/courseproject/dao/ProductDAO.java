package by.bsuir.courseproject.dao;

import by.bsuir.courseproject.entity.Product;

import java.util.List;

public interface ProductDAO extends BaseDAO<Product> {
    List<Product> findAll() throws DAOException;
}
