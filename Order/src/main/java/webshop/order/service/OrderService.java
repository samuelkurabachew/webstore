package webshop.order.service;

public interface OrderService {

    void createOrder(String shoppingCartNumber);

    void confirmOrder(String orderNumber,String customerId);


}
