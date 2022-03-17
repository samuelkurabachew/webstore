package webshop.client.domain.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class Order {
    private String orderNumber;
    private Date orderDate;
    private Character status;
    private List<OrderLine> orderLine;
    private Customer customer;
}
