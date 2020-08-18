package by.bsuir.courseproject.service;

import java.util.Map;

public interface WarehouseProductService {
    Map<Integer, Integer> findSuppliers(int idWarehouse) throws ServiceException;
}
