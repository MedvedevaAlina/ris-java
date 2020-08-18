package by.bsuir.courseproject.command.impl.customer;

import by.bsuir.courseproject.command.Command;
import by.bsuir.courseproject.command.CommandException;
import by.bsuir.courseproject.command.CommandResultPage;
import by.bsuir.courseproject.command.impl.admin.ShowWorkersCommand;
import by.bsuir.courseproject.entity.Orders;
import by.bsuir.courseproject.entity.Product;
import by.bsuir.courseproject.service.ServiceException;
import by.bsuir.courseproject.service.impl.OrdersServiceImpl;
import by.bsuir.courseproject.service.impl.ProductServiceImpl;
import by.bsuir.courseproject.util.constant.PageLocation;
import by.bsuir.courseproject.util.constant.ParameterName;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowItemsCommand implements Command {

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
        if(cat.equals("drink")){
            resultPage.setPage("/jsp/customer/purchase1.jsp");
        }
        if(cat.equals("juice")){
            resultPage.setPage("/jsp/customer/purchase2.jsp");
        }
        if(cat.equals("water")){
            resultPage.setPage(PageLocation.PURCHASE_PAGE);
        }
        request.setAttribute("category", cat);
        return resultPage;
    }
}
