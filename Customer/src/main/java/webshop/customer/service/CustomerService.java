package webshop.customer.service;

import webshop.customer.domain.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    Customer getCustomer(String customerNumber);

    List<Customer> getAllCustomer();

    void deleteCustomer(String customerNumber);
}
