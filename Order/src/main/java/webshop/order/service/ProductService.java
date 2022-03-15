package webshop.order.service;

import java.util.Map;

public interface ProductService {

    Boolean UpdateProductStock(Map<String,Integer> productList);
}
