package webshop.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import webshop.product.domain.Stock;

public interface StockRepository extends MongoRepository<Stock, String> {
}
