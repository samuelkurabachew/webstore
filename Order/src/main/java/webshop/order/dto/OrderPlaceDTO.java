package webshop.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class OrderPlaceDTO implements Serializable {

    private String shoppingCartNumber;

}
