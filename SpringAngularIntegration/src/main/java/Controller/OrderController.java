package Controller;

import orders.Order;
import orders.OrdersFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @RequestMapping(method = RequestMethod.GET, value = "/{orderId}/")
    public List<Order> getClient(@PathVariable Long orderId) {
        return OrdersFactory.getInstance().getOrderDAO().getOrdersById(orderId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<Order> getAllCards(){
        List<Order> orders = OrdersFactory.getInstance().getOrderDAO().getAllOrders();
        return orders;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{orderId}")
    public void delete(@PathVariable Long orderId){
        Order orders = OrdersFactory.getInstance().getOrderDAO().getOrderById(orderId);
        OrdersFactory.getInstance().getOrderDAO().delete(orders);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void addClient(@RequestBody Order order){
        OrdersFactory.getInstance().getOrderDAO().add(order);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{orderId}")
    public void update(@RequestBody Order order, @PathVariable Long orderId){
        order.setId(orderId);
        OrdersFactory.getInstance().getOrderDAO().update(order);
    }
}
