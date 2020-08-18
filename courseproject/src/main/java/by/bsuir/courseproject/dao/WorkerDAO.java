package by.bsuir.courseproject.dao;

import by.bsuir.courseproject.entity.Worker;

import java.util.List;

public interface WorkerDAO extends BaseDAO<Worker> {
    List<Worker> findAll() throws DAOException;
    Worker findById(int id) throws DAOException;
    List<Worker> searchBySurname(String surname) throws DAOException;
}
