package webshop.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshop.order.entity.Order;
import webshop.order.entity.ShoppingCart;
import webshop.order.feignClient.ShoppingCartInterface;
import webshop.order.repository.OrderRepository;
import webshop.order.service.OrderService;
import webshop.order.service.ProductService;

import static webshop.order.util.OrderUtils.mapTOrder;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final ProductService productService;

    @Autowired
    ShoppingCartInterface shoppingCartInterface;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    @Override
    public String createOrder(String shoppingCartNumber) {
        ShoppingCart shoppingCart=shoppingCartInterface.getShoppingcart(shoppingCartNumber);
        Order order=mapTOrder(shoppingCart);
 orderRepository.save(order);
 return order.getOrderNumber();
    }

    @Override
    public void confirmOrder(String orderNumber,String customerId) {

    }
}
