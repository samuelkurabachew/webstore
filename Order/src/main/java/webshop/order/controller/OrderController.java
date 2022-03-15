package webshop.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webshop.order.service.EmailSender;
import webshop.order.service.OrderService;
import webshop.order.util.EmailUtil;

@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;
    private final EmailSender emailSender;

    public OrderController(OrderService orderService,
                           EmailSender emailSender) {
        this.orderService = orderService;
        this.emailSender = emailSender;
    }

    @GetMapping
    public ResponseEntity<?> test() {
        emailSender.sendEmail(EmailUtil.mapToEmailRequestDTO());
        return ResponseEntity.ok("test");
    }

    @GetMapping("/{shoppingCartNumber}")
    public ResponseEntity<?> placeOrder(@PathVariable("shoppingCartNumber") String shoppingCartNumber) {
        orderService.createOrder(shoppingCartNumber);
        return ResponseEntity.ok().build();
    }
}
