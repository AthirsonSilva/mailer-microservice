package com.microservice.mailermicroservice.services;

import com.microservice.mailermicroservice.models.Email;
import com.microservice.mailermicroservice.models.StatusEmail;
import com.microservice.mailermicroservice.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(Email email) {
        email.setCreatedAt(LocalDateTime.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(email.getFromEmail());
            message.setTo(email.getToEmail());
            message.setSubject(email.getSubjectEmail());
            message.setText(email.getBodyEmail());

            emailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            email.setStatusEmail(StatusEmail.ERROR);
        } finally {
            emailRepository.save(email);
        }
    }
}
