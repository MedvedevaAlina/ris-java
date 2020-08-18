package by.bsuir.courseproject.service.impl;

import by.bsuir.courseproject.dao.DAOException;
import by.bsuir.courseproject.dao.WarehouseProductDAO;
import by.bsuir.courseproject.dao.factory.DAOFactory;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.WarehouseProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class WarehouseProductServiceImpl implements WarehouseProductService {
    private static Logger logger = LogManager.getLogger();
    private final static WarehouseProductServiceImpl instance= new WarehouseProductServiceImpl();
    private WarehouseProductDAO wpDAO = DAOFactory.getInstance().getWarehouseProductDAO();

    private WarehouseProductServiceImpl() {  }

    public static WarehouseProductServiceImpl getInstance() {
        return instance;
    }
    @Override
    public Map<Integer, Integer> findSuppliers(int idWarehouse) throws ServiceException{
        try {
            return wpDAO.findSuppliers(idWarehouse);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
