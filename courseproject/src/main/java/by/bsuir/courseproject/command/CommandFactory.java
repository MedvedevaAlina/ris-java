package by.bsuir.courseproject.command;

import by.bsuir.courseproject.command.impl.ChangePasswordCommand;
import by.bsuir.courseproject.command.impl.LoadPageCommand;
import by.bsuir.courseproject.command.impl.LoginCommand;
import by.bsuir.courseproject.command.impl.LogoutCommand;
import by.bsuir.courseproject.command.impl.admin.*;
import by.bsuir.courseproject.command.impl.customer.*;
import by.bsuir.courseproject.command.impl.worker.AdoptOrderCommand;
import by.bsuir.courseproject.command.impl.worker.EditProfileWorkerCommand;
import by.bsuir.courseproject.command.impl.worker.ShowItemsToWarehouseCommand;
import by.bsuir.courseproject.command.impl.worker.ShowProcessedOrdersCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandFactory {
    private static Logger logger = LogManager.getLogger();
    public static Command define(String command) throws CommandException {
        switch (command){
            case CommandName.LOGIN:
                return new LoginCommand();
            case CommandName.LOGOUT:
                return new LogoutCommand();
            case CommandName.CHANGE_PASSWORD:
                return new ChangePasswordCommand();
            case CommandName.SHOW_WORKERS:
                return new ShowWorkersCommand();
            case CommandName.LOAD_PAGE:
                return new LoadPageCommand();
            case CommandName.ADD_WORKER:
                return new AddWorkerCommand();
            case CommandName.FIND_WORKER:
                return new FindWorkerCommand();
            case CommandName.EDIT_WORKER:
                return new EditWorkerCommand();
            case CommandName.DELETE_USER:
                return new DeleteUserCommand();
            case CommandName.SEARCH_WORKER:
                return new SearchWorkerCommand();
            case CommandName.SHOW_ORDERS:
                return new ShowOrdersCommand();
            case CommandName.CHECK_ORDER:
                return new CheckOrderCommand();
            case CommandName.ADOPT_ORDER:
                return new AdoptOrderCommand();
            case CommandName.SHOW_CUSTOMERS:
                return new ShowCustomersCommand();
            case CommandName.ADD_CUSTOMER:
                return new AddCustomerCommand();
            case CommandName.FIND_CUSTOMER:
                return new FindCustomerCommand();
            case CommandName.EDIT_CUSTOMER:
                return new EditCustomerCommand();
            case CommandName.SEARCH_CUSTOMER:
                return new SearchCustomerCommand();
            case CommandName.SHOW_ITEMS:
                return new ShowItemsCommand();
            case CommandName.SUBMIT_ORDER:
                return new SubmitOrderCommand();
            case CommandName.SHOW_HISTORY:
                return new ShowHistoryCommand();
            case CommandName.SHOW_ITEMS_TO_WAREHOUSE:
                return new ShowItemsToWarehouseCommand();
            case CommandName.SEARCH_ORDER:
                return new SearchOrderCommand();
            case CommandName.SHOW_ORDERS_FOR_WORKER:
                return new ShowProcessedOrdersCommand();
            case CommandName.EDIT_PROFILE_CUSTOMER:
                return new EditProfileCustomerCommand();
            case CommandName.EDIT_PROFILE_WORKER:
                return new EditProfileWorkerCommand();
            default: {
                logger.error(CommandName.ILLEGAL_COMMAND + command);
                throw new CommandException(CommandName.ILLEGAL_COMMAND);
            }
        }
    }
}
