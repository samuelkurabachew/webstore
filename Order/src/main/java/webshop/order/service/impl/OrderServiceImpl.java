package webshop.order.service.impl;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import webshop.order.dto.EmailRequestDTO;
import webshop.order.dto.OrderConfirmDTO;
import webshop.order.dto.OrderPlaceDTO;
import webshop.order.dto.ShoppingCartDTO;
import webshop.order.entity.Customer;
import webshop.order.entity.Order;
import webshop.order.feignClient.CustomerInterface;
import webshop.order.repository.OrderRepository;
import webshop.order.service.OrderService;
import webshop.order.service.ProductService;

import java.util.NoSuchElementException;
import java.util.Objects;

import static webshop.order.util.EmailUtil.mapToEmailRequestDTO;
import static webshop.order.util.OrderUtils.getProductQuantity;
import static webshop.order.util.OrderUtils.mapTOrder;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final ProductService productService;

    private final CustomerInterface customerInterface;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ProductService productService, CustomerInterface customerInterface) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.customerInterface = customerInterface;
    }

    @Override
    @SneakyThrows
    public Order createOrder(OrderPlaceDTO requestDTO) {
        ShoppingCartDTO shoppingCart = requestDTO.getShoppingCartDTO();
        Customer customer=customerInterface.createCustomer(requestDTO.getCustomerDTO());

        if(Objects.isNull(shoppingCart) && Objects.isNull(customer)){
            return null;
        }
        Order order = mapTOrder(shoppingCart,customer);
        orderRepository.save(order);
        return order;
    }

    @Override
    public void confirmOrder(OrderConfirmDTO confirmDTO) {
        Order order=orderRepository.findById(confirmDTO.getOrderNumber()).orElseGet(()->{
            throw new NoSuchElementException("Sorry, Order not found");
        });
        Boolean message=productService.UpdateProductStock(getProductQuantity(order));
        if(!message){
            throw new RuntimeException("Sorry! Product out of stock");
        }
        order.setStatus('Y');
        EmailRequestDTO emailRequestDTO=mapToEmailRequestDTO(order.getCustomer());
        String responseEntity=customerInterface.sendEmail(emailRequestDTO);
        if(!responseEntity.equals("Email Sent....")){
            System.out.println("Mail cannot be sent");
        }
    }

    @Override
    public Order getOrder(String orderNumber) {
        return orderRepository.findById(orderNumber).orElse(null);
    }
}
