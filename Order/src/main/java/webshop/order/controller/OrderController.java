package webshop.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webshop.order.dto.OrderConfirmDTO;
import webshop.order.dto.OrderPlaceDTO;
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
//
//    @GetMapping
//    public ResponseEntity<?> test() {
//        emailSender.sendEmail(EmailUtil.mapToEmailRequestDTO());
//        return ResponseEntity.ok("test");
//    }

    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(@RequestBody OrderPlaceDTO requestDTO) {
        String orderNumber=orderService.createOrder(requestDTO);
        return ResponseEntity.ok(orderNumber);
    }

    @PostMapping("/confirm")
    public ResponseEntity<?> confirmOrder(@RequestBody OrderConfirmDTO requestDTO) {
        orderService.confirmOrder(requestDTO);
        return ResponseEntity.ok("Dear Customer.\n Your order has been confirmed.\n \n Thank you!");
    }
}
