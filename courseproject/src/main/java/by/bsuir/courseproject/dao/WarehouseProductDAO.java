package by.bsuir.courseproject.dao;

import by.bsuir.courseproject.entity.WarehouseProduct;

import java.util.List;
import java.util.Map;

public interface WarehouseProductDAO extends BaseDAO<WarehouseProduct> {
    Map<Integer, Integer> findSuppliers(int idWarehouse) throws DAOException;
}
