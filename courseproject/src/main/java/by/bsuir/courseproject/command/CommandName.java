package by.bsuir.courseproject.command;

//todo можно ли оставить классом, а не енам
public class CommandName {
    public static final String LOGIN = "login";
    public static final String LOGOUT = "logout";
    public static final String CHANGE_PASSWORD = "change_password";
    public static final String SHOW_WORKERS = "show_workers";
    public static final String SHOW_CUSTOMERS = "show_customers";
    public static final String LOAD_PAGE = "load_page";
    public static final String ADD_WORKER = "add_worker";
    public static final String FIND_WORKER = "find_worker";
    public static final String EDIT_WORKER = "edit_worker";
    public static final String DELETE_USER = "delete_user";
    public static final String SEARCH_WORKER = "search_worker";
    public static final String SHOW_ORDERS = "show_orders";
    public static final String CHECK_ORDER = "check_order";
    public static final String ADOPT_ORDER = "adopt_order";
    public static final String SEARCH_ORDER = "search_order";
    public static final String SHOW_ORDERS_FOR_WORKER = "show_processed_orders";

    public static final String ADD_CUSTOMER = "add_customer";
    public static final String FIND_CUSTOMER = "find_customer";
    public static final String EDIT_CUSTOMER = "edit_customer";
    public static final String SEARCH_CUSTOMER = "search_customer";
    public static final String SHOW_ITEMS = "show_items";
    public static final String SHOW_ITEMS_TO_WAREHOUSE = "show_items_to_warehouse";
    public static final String SUBMIT_ORDER = "submit_order";
    public static final String SHOW_HISTORY = "show_history";
    public static final String EDIT_PROFILE_CUSTOMER = "edit_profile_customer";
    public static final String EDIT_PROFILE_WORKER = "edit_profile_worker";




    public static final String ILLEGAL_COMMAND = "Such command doesn't exist!";

}
