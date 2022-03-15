package webshop.order.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartLine {

    private Integer quantity;

    private Product product;
}
