package webshop.order.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection="webstore")
@Getter
@Setter
@ToString
public class Order {
   @Id
    private String orderNumber;
    private Date orderDate;
    private Character status;
    private List<OrderLine> orderLine;
}
