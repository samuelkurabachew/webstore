package webshop.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OrderConfirmDTO implements Serializable {

    private String orderNumber;
    private String  customerId;
}
