package webshop.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.order.domain.Order;
import webshop.order.domain.OrderFactory;
import webshop.order.domain.ShoppingCart;
import webshop.order.repository.OrderRepository;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order getOrder(String orderNumber) {
        Optional<Order> order = orderRepository.findById(orderNumber);

        return order.orElse(null);
    }

    public void createOrder(ShoppingCart cart) {
        Order order = OrderFactory.createOrder(cart);

        orderRepository.save(order);
    }
}
