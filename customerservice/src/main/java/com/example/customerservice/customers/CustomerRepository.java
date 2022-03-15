package com.example.customerservice.customers;

import com.example.customerservice.customers.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
