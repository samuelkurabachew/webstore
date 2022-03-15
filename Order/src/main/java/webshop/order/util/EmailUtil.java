package webshop.order.util;

import webshop.order.dto.EmailRequestDTO;
import webshop.order.entity.Customer;

public class EmailUtil {

    public static EmailRequestDTO mapToEmailRequestDTO(Customer customer){
        return EmailRequestDTO.builder()
                .customerName(customer.getFirstName()+" "+customer.getLastName())
                .message("\nYour Order has been Placed.\n \nThank you.")
                .setTo(customer.getEmail())
                .build();
    }
}
