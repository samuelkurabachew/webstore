package webshop.order.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

// Stub Class
@Getter
public class ShoppingCart {

    private String shoppingCartId;

    private List<CartLine> cartLineList = new ArrayList<>();

    public String getShoppingCartId() {
        return shoppingCartId;
    }

    public List<CartLine> getCartLineList() {
        return cartLineList;
    }
}
