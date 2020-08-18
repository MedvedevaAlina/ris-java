package by.bsuir.courseproject.dao;

import by.bsuir.courseproject.entity.User;

import java.util.Optional;

public interface UserDAO extends BaseDAO<User>{
    Optional<User> findUserByLoginPassword(String login, String password) throws DAOException;
    boolean delete(int id) throws DAOException;
}
