package webshop.order.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmailRequestDTO {

    private String setTo;
    private String message;
    private String customerName;
}
