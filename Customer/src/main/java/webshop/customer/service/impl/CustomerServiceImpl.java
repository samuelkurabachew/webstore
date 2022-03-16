package webshop.customer.service.impl;

import lombok.SneakyThrows;
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

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getCustomer(String customerNumber) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerNumber);
        return  optionalCustomer.orElse(null);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    @SneakyThrows
    public Customer addCustomer(Customer customer) {
        List<Customer> existingCustomer=findCustomerByNameAndEmail(customer);
        if(existingCustomer.size()>0){
            throw new Exception("Duplcaite Data");
        }
        customer.setStatus('Y');
        return customerRepository.save(customer);
    }


    @Override
    @SneakyThrows
    public Customer updateCustomer(Customer customer) {
        List<Customer> existingCustomer=findCustomerByNameAndEmail(customer);
        if(existingCustomer.size()>0){
            throw new Exception("Duplcaite Data");
        }
        Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerNumber());
        if(optionalCustomer.isPresent()){
           deleteCustomer(customer.getCustomerNumber());
        }
        customer.setStatus('Y');
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(String customerNumber) {
        Customer customer=getCustomer(customerNumber);
        if(Objects.isNull(customer)){
            System.out.println("Customer not found");
            return;
        }
        customer.setStatus('D');
        customerRepository.save(customer);
    }

    public List<Customer> findCustomerByNameAndEmail(Customer customer){
        List<Customer> existingCustomer=customerRepository.getCustomerByNameAndEmail(customer.getFirstName(),
                customer.getLastName(),
                customer.getContactInformation().getEmail());

        return existingCustomer;
    }
}
