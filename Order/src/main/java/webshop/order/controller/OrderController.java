package webshop.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webshop.order.domain.Order;
import webshop.order.domain.ShoppingCart;
import webshop.order.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders/{orderNumber}")
    public ResponseEntity<?> getCart(@PathVariable String orderNumber) {
        Order order = orderService.getOrder(orderNumber);
        if (order == null) {
            return new ResponseEntity<>(new CustomErrorType("Order with order number: "
                    + orderNumber + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody ShoppingCart cart) {
        orderService.createOrder(cart);

        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
}
