package orders;

public class OrdersFactory {
    private static OrdersFactory instance;
    private static OrderDAO orderDAO;

    private OrdersFactory(){}

    public static synchronized OrdersFactory getInstance(){
        if(instance == null){
            instance = new OrdersFactory();
        }
        return instance;
    }

    public OrderDAO getOrderDAO(){
        if(orderDAO == null){
            orderDAO = new OrderDAOImpl();
        }
        return orderDAO;
    }
}
