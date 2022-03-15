package webshop.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import webshop.customer.domain.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
}
