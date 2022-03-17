package webstore.productservicereplica2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import webstore.productservicereplica2.domain.Stock;

public interface StockRepository extends MongoRepository<Stock, String> {
}
