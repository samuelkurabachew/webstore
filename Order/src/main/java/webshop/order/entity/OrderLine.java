package webshop.order.entity;

import lombok.Getter;
import lombok.Setter;
import webshop.order.dto.Product;

@Getter
@Setter
public class OrderLine {

    private Integer quantity;

    private Product product;
}
