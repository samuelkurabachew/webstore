package webshop.customer.service;

import webshop.customer.domain.Customer;


public interface CustomerService {
    Customer getCustomer(String customerNumber);

    Customer addCustomer(Customer customer);


    Customer updateCustomer(Customer customer);

    void deleteCustomer(String customerNumber);
}
