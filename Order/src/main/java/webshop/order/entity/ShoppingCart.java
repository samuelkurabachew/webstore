package webshop.order.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShoppingCart {

    private String shoppingCartNumber;
    private List<CartLine> cartLines;
}
