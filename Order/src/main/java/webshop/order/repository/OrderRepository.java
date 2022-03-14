package webshop.order.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import webshop.order.domain.Order;

public interface OrderRepository extends MongoRepository<Order, String> {

}
