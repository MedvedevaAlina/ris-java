package by.bsuir.courseproject.dao;

public interface BaseDAO<T> {
    boolean update(T t) throws DAOException;
    int add(T t) throws DAOException;
}
