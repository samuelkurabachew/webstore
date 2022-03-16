package webshop.customer.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "webstore")
@Getter
@Setter
@ToString
public class Email {

    @Id
    private String emailId;

    private String emailAddress;

    private String message;

    private Character status;
}
