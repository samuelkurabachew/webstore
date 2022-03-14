package webshop.order.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Order {

    @Id
    private String orderNumber;
    private OrderStatus status;

    private List<OrderLine> orderLineList = new ArrayList<>();

    public Order() {

    }

    public Order(String orderNumber, OrderStatus status) {
        this.orderNumber = orderNumber;
        this.status = status;
    }

    public void addOrderLine(OrderLine orderLine) {
        orderLineList.add(orderLine);
    }



    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
