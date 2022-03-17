package webstore.productservicereplica.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import webstore.productservicereplica.domain.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}
