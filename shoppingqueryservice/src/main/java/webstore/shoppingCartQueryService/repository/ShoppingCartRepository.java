package webstore.shoppingCartQueryService.repository;

import webstore.shoppingCartQueryService.domain.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {
}
