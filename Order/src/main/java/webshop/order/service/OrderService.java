package webshop.order.service;

public interface OrderService {

    String createOrder(String shoppingCartNumber);

    void confirmOrder(String orderNumber,String customerId);


}
