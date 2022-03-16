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

    @PostMapping("/api/v1/customers")
    Customer createCustomer(@RequestBody CustomerDTO customerDTO);

    @PostMapping("/api/v1/customers/email")
    String sendEmail(@RequestBody EmailRequestDTO emailRequestDTO);
}
