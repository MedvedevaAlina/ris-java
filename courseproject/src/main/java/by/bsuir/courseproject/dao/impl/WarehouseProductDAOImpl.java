package by.bsuir.courseproject.dao.impl;

import by.bsuir.courseproject.command.impl.admin.FindWorkerCommand;
import by.bsuir.courseproject.dao.DAOException;
import by.bsuir.courseproject.dao.WarehouseProductDAO;
import by.bsuir.courseproject.entity.WarehouseProduct;
import by.bsuir.courseproject.util.HibernateSessionFactoryUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WarehouseProductDAOImpl implements WarehouseProductDAO {
    private final static Logger logger = LogManager.getLogger(FindWorkerCommand.class);

    private static final String SELECT_SUM_QUANTITY = "select sum(wp.quantity) from WarehouseProduct as wp " +
            "group by wp.id.product.idProduct order by wp.id.product.idProduct asc ";
    private static final String SELECT_ID_PRODUCT = "select distinct wp.id.product.idProduct from WarehouseProduct as wp " +
            " order by wp.id.product.idProduct asc";
    @Override
    public Map<Integer,Integer> findSuppliers(int idWarehouse) throws DAOException {
        Map<Integer, Integer> map = new HashMap<>();
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            List<Integer> quantity = (List<Integer>) session.createQuery(SELECT_SUM_QUANTITY).list();
            List<Integer> idProducts = (List<Integer>) session.createQuery(SELECT_ID_PRODUCT).list();
            session.close();


            for (int i = 0; i < idProducts.size(); i++) {
                map.put(idProducts.get(i), quantity.get(i));
            }
            session.close();
        }catch (Exception e){
            logger.error("Can't find suppliers in Warehouse ", e);
            throw new DAOException(e);
        }
        return map;
    }

    @Override
    public boolean update(WarehouseProduct warehouseProduct) throws DAOException {
        return false;
    }

    @Override
    public int add(WarehouseProduct warehouseProduct) throws DAOException {
        return 0;
    }
}
