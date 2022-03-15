package webshop.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ShoppingCartDTO implements Serializable {

    private String cartNumber;

    private List<ProductLine> productLineList;

    ShoppingCartDTO(){

    }
}
