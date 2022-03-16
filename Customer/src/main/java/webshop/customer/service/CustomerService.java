package webshop.customer.service;

import webshop.customer.domain.Customer;

public interface CustomerService {
    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    Customer getCustomer(String customerNumber);

    void deleteCustomer(String customerNumber);
}
