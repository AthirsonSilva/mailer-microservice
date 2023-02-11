package com.microservice.mailermicroservice.controllers;

import com.microservice.mailermicroservice.dtos.EmailDTO;
import com.microservice.mailermicroservice.models.Email;
import com.microservice.mailermicroservice.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<Email> sendEmail(@RequestBody @Valid EmailDTO emailDTO) {
        Email email = new Email();
        BeanUtils.copyProperties(emailDTO, email);
        emailService.sendEmail(email);

        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }
}
