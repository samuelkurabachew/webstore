package webshop.order.service;

import webshop.order.dto.OrderConfirmDTO;
import webshop.order.dto.OrderPlaceDTO;

public interface OrderService {

    String createOrder(OrderPlaceDTO requestDTO);

    String confirmOrder(OrderConfirmDTO confirmDTO);


}
