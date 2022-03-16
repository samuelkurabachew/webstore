package webstore.shoppingqueryservice.repository;

import webstore.shoppingqueryservice.domain.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {
}
