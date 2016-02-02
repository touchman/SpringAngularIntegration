package orders;

import java.util.List;

public interface OrderDAO {
    void add(Order order);
    List<Order> getAllOrders();
    void update(Order order);
    void delete(Order order);
    Order getOrderById(Long id);
    List<Order> getOrdersById(Long id);
}
