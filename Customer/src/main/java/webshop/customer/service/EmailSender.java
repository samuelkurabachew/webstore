package webshop.customer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import webshop.customer.dto.EmailRequestDTO;

@Service
public class EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    @HystrixCommand(fallbackMethod = "emailFallBack")
    public String sendEmail(EmailRequestDTO requestDTO) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(requestDTO.getSetTo());

        msg.setSubject("Order Confirmation");
        msg.setText("Dear " + requestDTO.getCustomerName() + "," + "\n" + requestDTO.getMessage());

        javaMailSender.send(msg);
        return "Email Sent....";
    }

    public String emailFallBack(EmailRequestDTO requestDTO) {
        return "Sorry, email cannot be sent to "+requestDTO.getCustomerName()+". But Order has been placed";
    }
}
