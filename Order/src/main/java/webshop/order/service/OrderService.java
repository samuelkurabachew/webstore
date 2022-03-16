package webshop.order.service;

import webshop.order.dto.OrderConfirmDTO;
import webshop.order.dto.OrderPlaceDTO;
import webshop.order.entity.Order;

public interface OrderService {

    Order createOrder(OrderPlaceDTO requestDTO);

    void confirmOrder(OrderConfirmDTO confirmDTO);


}
