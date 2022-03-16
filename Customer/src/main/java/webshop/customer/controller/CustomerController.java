package webshop.customer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webshop.customer.domain.Customer;
import webshop.customer.dto.EmailRequestDTO;
import webshop.customer.service.impl.CustomerServiceImpl;
import webshop.customer.service.EmailSender;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

    private CustomerServiceImpl customerServiceImpl;

    private final EmailSender emailSender;


    CustomerController(CustomerServiceImpl customerServiceImpl, EmailSender emailSender) {
        this.customerServiceImpl = customerServiceImpl;
        this.emailSender = emailSender;
    }

    @GetMapping(path = "/{customerNumber}")
    public ResponseEntity<?> getCustomer(@PathVariable String customerNumber) {
        Optional<Customer> optionalCustomer = Optional.ofNullable(customerServiceImpl.getCustomer(customerNumber));
        if (optionalCustomer.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(optionalCustomer.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        Optional<Customer> optionalCustomer = Optional.ofNullable(customerServiceImpl.addCustomer(customer));
        if (optionalCustomer.isEmpty())
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
        Optional<Customer> optionalCustomer = Optional.ofNullable(customerServiceImpl.updateCustomer(customer));
        if (optionalCustomer.isEmpty())
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{customerNumber}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String customerNumber) {
        customerServiceImpl.deleteCustomer(customerNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/email")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequestDTO emailRequestDTO) {
        emailSender.sendEmail(emailRequestDTO);
        return ResponseEntity.ok("Email Sent....");
    }


}
