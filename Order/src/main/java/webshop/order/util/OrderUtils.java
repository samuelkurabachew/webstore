package webshop.order.util;

import webshop.order.dto.ShoppingCartDTO;
import webshop.order.entity.Customer;
import webshop.order.entity.Order;
import webshop.order.entity.OrderLine;

import java.util.*;

import static webshop.order.util.RandomNumberGenerator.getRandomNumbers;

public class OrderUtils {

    public static Order mapTOrder(ShoppingCartDTO shoppingCart, Customer customer){
        List<OrderLine> orderLineList=new ArrayList<>();
        Order order=new Order();
        shoppingCart.getProductLineList().forEach(cartLine -> {
            OrderLine orderLine=new OrderLine();
            orderLine.setQuantity(cartLine.getQuantity());
            orderLine.setProduct(cartLine.getProduct());
            orderLineList.add(orderLine);
        });
        order.setOrderLine(orderLineList);
        order.setOrderDate(new Date());
        order.setOrderNumber(getRandomNumbers());
        order.setCustomer(customer);
        order.setStatus('N');
        return order;
    }

    public static Map<String, Integer> getProductQuantity(Order order){
        Map<String, Integer> mapProductQuantity=new HashMap<>();
        order.getOrderLine().forEach(oLine->{
            mapProductQuantity.put(oLine.getProduct().getProductNumber(),oLine.getQuantity());
        });
        return mapProductQuantity;
    }
}
