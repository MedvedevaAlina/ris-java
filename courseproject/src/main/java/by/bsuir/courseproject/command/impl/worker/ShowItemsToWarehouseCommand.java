package by.bsuir.courseproject.command.impl.worker;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.command.impl.admin.ShowWorkersCommand;
import by.bsuir.courseproject.entity.Product;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.impl.ProductServiceImpl;
import by.bsuir.courseproject.util.constant.PageLocation;
import by.bsuir.courseproject.util.constant.ParameterName;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowItemsToWarehouseCommand implements Command {

    private final static Logger logger = LogManager.getLogger(ShowWorkersCommand.class);

    @Override
    public CommandResultPage execute(HttpServletRequest request) throws CommandException {
        CommandResultPage resultPage = new CommandResultPage();
        List<Product> products;
        try {
            products = ProductServiceImpl.getInstance().findAll();
            request.setAttribute(ParameterName.PRODUCTS, products);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
        }
        String cat = request.getParameter("category");
        resultPage.setPage("/jsp/worker/addToWarehouse.jsp");
        request.setAttribute("category", cat);
        return resultPage;
    }
}
