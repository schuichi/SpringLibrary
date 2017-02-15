package TomekD.service.impl;

import TomekD.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendEmail(String fromAddress, String toAddress, String subject, String body) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(toAddress);
        mailMessage.setFrom(fromAddress);
        mailMessage.setSubject("[SzkolenieSpring] " + subject);
        mailMessage.setText(body);

        mailSender.send(mailMessage);
    }
}
