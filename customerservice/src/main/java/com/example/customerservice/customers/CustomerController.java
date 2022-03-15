package com.example.customerservice.customers;

import com.example.customerservice.customers.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

    private CustomerService customerService;

    CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping(path = "/{customerNumber}")
    public ResponseEntity<?> getCustomer(@PathVariable String customerNumber){
        Optional<Customer> optionalCustomer = Optional.ofNullable(customerService.getCustomer(customerNumber));
        if(optionalCustomer.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(optionalCustomer.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        Optional<Customer> optionalCustomer = Optional.ofNullable(customerService.addCustomer(customer));
        if(optionalCustomer.isEmpty())
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
        Optional<Customer> optionalCustomer = Optional.ofNullable(customerService.updateCustomer(customer));
        if(optionalCustomer.isEmpty())
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{customerNumber}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String customerNumber){
        customerService.deleteCustomer(customerNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
