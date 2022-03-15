package webshop.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String productNumber;

    private String description;

    private Double price;
}
