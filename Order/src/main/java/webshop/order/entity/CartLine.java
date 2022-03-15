package webshop.order.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

@Getter
@Setter
public class CartLine {

    private Integer quantity;

    private Product product;
}
