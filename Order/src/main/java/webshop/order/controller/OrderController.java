package webshop.order.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webshop.order.dto.OrderConfirmDTO;
import webshop.order.dto.OrderPlaceDTO;
import webshop.order.entity.Order;
import webshop.order.error.CustomErrorType;
import webshop.order.service.OrderService;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(@RequestBody OrderPlaceDTO requestDTO) {
        Order order=new Order();
        try{order=orderService.createOrder(requestDTO);
        }catch (Exception ex){
            return ResponseEntity.ok(getCustomErrorType("Sorry, order cannot be placed"));
        }
        return ResponseEntity.ok(order);
    }



    @PostMapping("/confirm")
    public ResponseEntity<?> confirmOrder(@RequestBody OrderConfirmDTO requestDTO) {
        String message="";
        try{
           message= orderService.confirmOrder(requestDTO);
        }catch (RuntimeException ex){
            System.out.println("Confirm issue");
            return ResponseEntity.ok(new CustomErrorType("Sorry, cannot place your order. Try again later"));
        }
        return ResponseEntity.ok(message);
    }

    @GetMapping("/{orderNumber}")
    public ResponseEntity<?> getOrder(@PathVariable("orderNumber") String orderNumber) {
        Order order=orderService.getOrder(orderNumber);
        if(Objects.isNull(order)){
            return ResponseEntity.ok(getCustomErrorType("Sorry, Order not found with order number: "+orderNumber));
        }
        return ResponseEntity.ok(order);
    }

    public CustomErrorType getCustomErrorType(String message){
        return new CustomErrorType(message);
    }
}
