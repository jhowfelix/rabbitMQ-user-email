package com.ms.email.services;

import com.ms.email.model.EmailModel;
import com.ms.email.repositories.IEmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    @Autowired
    IEmailRepository iEmailRepository;
    @Autowired
    JavaMailSender javaMailSender;


    @Transactional
    public EmailModel sendEmail(EmailModel emailModel){
        emailModel.setEmailFrom(emailFrom);
        emailModel.setSendDateEmail(LocalDateTime.now());
        EmailModel savedEmail = iEmailRepository.save(emailModel);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setSubject(emailModel.getSubject());
        simpleMailMessage.setFrom(emailFrom);
        simpleMailMessage.setTo(emailModel.getEmailTo());
        simpleMailMessage.setText(emailModel.getText());

        javaMailSender.send(simpleMailMessage);

        return savedEmail;
    }





}
