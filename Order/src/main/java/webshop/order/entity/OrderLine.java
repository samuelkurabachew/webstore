package webshop.order.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderLine {

    private Integer quantity;

    private Product product;
}
