package webshop.order.service.impl;

import org.springframework.stereotype.Service;
import webshop.order.repository.OrderRepository;
import webshop.order.service.OrderService;
import webshop.order.service.ProductService;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    private ProductService productService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    @Override
    public void createOrder(String shoppingCartNumber) {


    }

    @Override
    public void confirmOrder(String orderNumber,String customerId) {

    }
}
