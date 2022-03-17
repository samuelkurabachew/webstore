package webshop.client.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OrderConfirm implements Serializable {

    private String orderNumber;
    private String  customerId;

    public OrderConfirm(String orderNumber, String customerId) {
        this.orderNumber = orderNumber;
        this.customerId = customerId;
    }
}
