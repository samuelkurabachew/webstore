package webshop.order.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document
public class Order {

    @Id
    private String orderNumber;
    private String status;

    public Order(String orderNumber, String status) {
        this.orderNumber = orderNumber;
        this.status = status;
    }
}
