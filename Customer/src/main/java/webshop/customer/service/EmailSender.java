package webshop.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import webshop.customer.dto.EmailRequestDTO;

@Service
public class EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(EmailRequestDTO requestDTO) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(requestDTO.getSetTo());

        msg.setSubject("Order Confirmation");
        msg.setText("Dear "+requestDTO.getCustomerName()+","+ "\n"+ requestDTO.getMessage());

        javaMailSender.send(msg);

    }
}
