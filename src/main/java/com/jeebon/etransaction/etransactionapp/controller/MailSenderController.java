package com.jeebon.etransaction.etransactionapp.controller;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
public class MailSenderController {
    @Autowired
    private JavaMailSender sender;

    @GetMapping("/sendMail")
    public String sendMail() {
        String to = "demo@gmail.com";
        String cc = "user1@example.com";

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo(to);
            helper.setText("Greetings!");
            helper.setSubject("Mail From Spring Boot");
            String[] ccList = cc.split(",");
            helper.setCc(ccList);
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Error while sending mail ..";
        }
        sender.send(message);
        return "Mail Sent Success!";
    }
}
