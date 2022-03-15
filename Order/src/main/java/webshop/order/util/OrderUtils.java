package webshop.order.util;

import webshop.order.entity.Order;
import webshop.order.entity.OrderLine;
import webshop.order.entity.ShoppingCart;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static webshop.order.util.RandomNumberGenerator.getRandomNumbers;

public class OrderUtils {

    public static Order mapTOrder(ShoppingCart shoppingCart){
        List<OrderLine> orderLineList=new ArrayList<>();
        Order order=new Order();
        shoppingCart.getCartLines().forEach(cartLine -> {
            OrderLine orderLine=new OrderLine();
            orderLine.setQuantity(cartLine.getQuantity());
            orderLine.setProduct(cartLine.getProduct());
            orderLineList.add(orderLine);
        });
        order.setOrderLine(orderLineList);
        order.setOrderDate(new Date());
        order.setOrderNumber(getRandomNumbers());
        return order;

    }
}
