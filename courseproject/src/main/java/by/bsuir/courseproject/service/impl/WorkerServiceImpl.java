package by.bsuir.courseproject.service.impl;

import by.bsuir.courseproject.dao.DAOException;
import by.bsuir.courseproject.dao.WorkerDAO;
import by.bsuir.courseproject.dao.factory.DAOFactory;
import by.bsuir.courseproject.entity.Worker;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.WorkerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class WorkerServiceImpl implements WorkerService<Worker> {
    private static Logger logger = LogManager.getLogger();
    private final static WorkerServiceImpl instance= new WorkerServiceImpl();
    private WorkerDAO workerDAO = DAOFactory.getInstance().getWorkerDAO();


    private WorkerServiceImpl() {  }

    public static WorkerServiceImpl getInstance() {
        return instance;
    }

    @Override
    public List<Worker> findAll() throws ServiceException {
        try {
            return workerDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public long save(Worker item) throws ServiceException {
        try {
            return workerDAO.add(item);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Worker> searchBySurname(String surname) throws ServiceException {
        try {
            return workerDAO.searchBySurname(surname);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean update(Worker item) throws ServiceException {
        try {
            return workerDAO.update(item);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Worker find(int id) throws ServiceException {
        try {
            return workerDAO.findById(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
