package webshop.product.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private String productNumber;
    private String name;
    private double price;
    private String description;
    private Stock stock;
    private Character status;


}
