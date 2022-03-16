package webshop.customer.util;

import webshop.customer.domain.Email;
import webshop.customer.dto.EmailRequestDTO;

public class EmailUtil {

    public static Email mapToEmail(EmailRequestDTO emailRequestDTO){
        Email email=new Email();
        email.setEmailAddress(emailRequestDTO.getSetTo());
        email.setMessage(emailRequestDTO.getMessage());
        email.setStatus('Y');

        return email;
    }
}
