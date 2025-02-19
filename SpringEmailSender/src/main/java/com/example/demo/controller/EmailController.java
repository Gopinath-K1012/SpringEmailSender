package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(
            @RequestParam String recipient,
            @RequestParam String subject,
            @RequestParam String body) {
        emailService.sendEmail(recipient, subject, body);
        return "Email sent successfully!";
    }
}