package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Email;
import com.example.demo.repo.EmailRepository;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private EmailRepository emailRepository;

    public void sendEmail(String recipient, String subject, String body) {
        // Send email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);

        // Save email details to the database
        Email email = new Email();
        email.setRecipient(recipient);
        email.setSubject(subject);
        email.setBody(body);
        email.setSentAt(LocalDateTime.now());
        emailRepository.save(email);
    }
}