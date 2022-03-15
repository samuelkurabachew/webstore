package webshop.order.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import webshop.order.dto.CustomerDTO;
import webshop.order.dto.EmailRequestDTO;
import webshop.order.entity.Customer;

@FeignClient("customer-service")
public interface CustomerInterface {

    @PostMapping("/customer")
    Customer createCustomer(@RequestBody CustomerDTO customerDTO);

    @PostMapping("/customer/email")
    ResponseEntity<?> sendEmail(@RequestBody EmailRequestDTO emailRequestDTO);
}
