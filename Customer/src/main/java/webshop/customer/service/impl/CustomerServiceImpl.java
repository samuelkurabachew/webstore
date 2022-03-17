package webshop.customer.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import webshop.customer.domain.Customer;
import webshop.customer.repository.CustomerRepository;
import webshop.customer.service.CustomerService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomer(String customerNumber) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerNumber);
        return optionalCustomer.orElse(null);
    }

    @Override
    @HystrixCommand(fallbackMethod = "createFallBack")
    public Customer addCustomer(Customer customer) {
        Customer existingCustomer = getCustomerByEmail(customer.getContactInformation().getEmail());
        if (Objects.nonNull(existingCustomer)) {
            return existingCustomer;
        }
        return customerRepository.save(customer);
    }

    public Customer createFallBack(Customer customer) {
        return null;
    }


    @Override
    public Customer updateCustomer(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerNumber());
        if (optionalCustomer.isPresent())
            customerRepository.deleteById(customer.getCustomerNumber());
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(String customerNumber) {
        customerRepository.deleteById(customerNumber);
    }

    public Customer getCustomerByEmail(String email) {
        List<Customer> customers = customerRepository.findAll();
        for (Customer customer1 : customers) {
            if (customer1.getContactInformation().getEmail().equals(email))
            {
                return customer1;
            }
        }
        return null;
    }
}
