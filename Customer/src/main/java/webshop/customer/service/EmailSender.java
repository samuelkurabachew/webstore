package webshop.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import webshop.customer.domain.Email;
import webshop.customer.dto.EmailRequestDTO;
import webshop.customer.repository.EmailRepository;

import static webshop.customer.util.EmailUtil.mapToEmail;

@Service
public class EmailSender {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(EmailRequestDTO requestDTO) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(requestDTO.getSetTo());

        msg.setSubject("Order Confirmation");
        msg.setText("Dear " + requestDTO.getCustomerName() + "," + "\n" + requestDTO.getMessage());
        Email email = mapToEmail(requestDTO);
        try {
            javaMailSender.send(msg);
            saveEmail(email);
            System.out.println("Email sent....");
        } catch (Exception e) {
            email.setStatus('N');
            saveEmail(email);
            System.out.println(e.getMessage());
        }
        emailRepository.findAll().forEach(f->{
            System.out.println(f.toString());
        });
    }

    public void saveEmail(Email email) {
        emailRepository.save(email);
    }


}
