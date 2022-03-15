package com.example.customerservice.customers;

import com.example.customerservice.customers.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(String customerNumber) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerNumber);
        return  optionalCustomer.orElse(null);
    }

    public Customer addCustomer(Customer customer) {return customerRepository.save(customer);}


    public Customer updateCustomer(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerNumber());
        if(optionalCustomer.isPresent())
            customerRepository.deleteById(customer.getCustomerNumber());
        return customerRepository.save(customer);
    }

    public void deleteCustomer(String customerNumber) {
        customerRepository.deleteById(customerNumber);
    }
}
