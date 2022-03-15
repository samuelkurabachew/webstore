package webshop.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OrderPlaceDTO implements Serializable {

    private ShoppingCartDTO shoppingCartDTO;

    private CustomerDTO  customerDTO;
}
