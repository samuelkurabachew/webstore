package webstore.shoppingCartCommandService.repository;

import webstore.shoppingCartCommandService.domain.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {
}
