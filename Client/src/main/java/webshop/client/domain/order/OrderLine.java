package webshop.client.domain.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderLine {

    private Integer quantity;

    private Product product;
}
