package webshop.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import webshop.customer.domain.Customer;
import webshop.customer.domain.Email;

@Repository
public interface EmailRepository extends MongoRepository<Email, String> {
}
