package webshop.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import webshop.customer.domain.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    @Query("{firstName: ?0, lastName: ?1, email: ?2}")
    List<Customer> getCustomerByNameAndEmail(String firstName,String lastName, String email);

}
