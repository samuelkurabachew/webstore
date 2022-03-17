package webstore.productservicereplica.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import webstore.productservicereplica.domain.Stock;

public interface StockRepository extends MongoRepository<Stock, String> {
}
