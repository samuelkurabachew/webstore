package webshop.order.service;

import java.util.Map;

public interface ProductService {

    String UpdateProductStock(Map<String,Integer> productList);
}
