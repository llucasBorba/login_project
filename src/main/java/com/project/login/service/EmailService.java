package com.project.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    public String sendTextMail(String receiver, String subject, String message){

        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(receiver);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(message);
            System.setProperty("mail.debug", "true");
            javaMailSender.send(simpleMailMessage);

            return "Email enviado";
        }catch (Exception e) {
            return "Email não enviado" + e.getMessage();

        }
    }


}
