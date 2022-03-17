package webstore.productservicereplica2.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import webstore.productservicereplica2.domain.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}
