package webshop.customer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webshop.customer.domain.Customer;
import webshop.customer.dto.EmailRequestDTO;
import webshop.customer.error.CustomErrorType;
import webshop.customer.service.CustomerService;
import webshop.customer.service.EmailSender;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

    private CustomerService customerService;

    private final EmailSender emailSender;


    CustomerController(CustomerService customerService, EmailSender emailSender) {
        this.customerService = customerService;
        this.emailSender = emailSender;
    }

    @GetMapping(path = "/{customerNumber}")
    public ResponseEntity<?> getCustomer(@PathVariable String customerNumber) {
        Optional<Customer> optionalCustomer = Optional.ofNullable(customerService.getCustomer(customerNumber));
        if (optionalCustomer.isEmpty())
            return new ResponseEntity<>(getCustomErrorType("Sorry, Customer not found"),HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(optionalCustomer.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        Optional<Customer> optionalCustomer = Optional.ofNullable(customerService.addCustomer(customer));
        if (optionalCustomer.isEmpty())
            return new ResponseEntity<>(getCustomErrorType("Sorry, Customer not created"),HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(optionalCustomer.get(),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
        Optional<Customer> optionalCustomer = Optional.ofNullable(customerService.updateCustomer(customer));
        if (optionalCustomer.isEmpty())
            return new ResponseEntity<>(getCustomErrorType("Sorry, Customer not updated"),HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{customerNumber}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String customerNumber) {
        try{
        customerService.deleteCustomer(customerNumber);
        return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(getCustomErrorType("Sorry, Customer cannot be deleted"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/email")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequestDTO emailRequestDTO) {
        try{
        emailSender.sendEmail(emailRequestDTO);
        return ResponseEntity.ok("Email Sent....");
        }catch (Exception ex){
            return new ResponseEntity<>(getCustomErrorType("Sorry, email not sent"),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public CustomErrorType getCustomErrorType(String message){
        return new CustomErrorType(message);
    }

}
