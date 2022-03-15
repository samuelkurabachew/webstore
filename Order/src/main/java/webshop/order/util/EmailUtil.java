package webshop.order.util;

import webshop.order.dto.EmailRequestDTO;

import java.util.function.Supplier;

public class EmailUtil {

    public static EmailRequestDTO mapToEmailRequestDTO(){
        return EmailRequestDTO.builder()
                .customerName("Sauravi Thapa")
                .message("\nYour Order has been Placed.\n \nThank you.")
                .setTo("thapa_sauravi@hotmail.com")
                .build();
    }
}
