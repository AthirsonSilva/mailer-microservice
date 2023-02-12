package com.microservice.mailermicroservice.controllers;

import com.microservice.mailermicroservice.dtos.EmailDTO;
import com.microservice.mailermicroservice.models.Email;
import com.microservice.mailermicroservice.models.StatusEmail;
import com.microservice.mailermicroservice.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin(origins = "http://localhost:3000/", maxAge = 3600)
@RequestMapping("/api/v1/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<Email> sendEmail(@RequestBody @Valid EmailDTO emailDTO) {
        Email email = new Email();

        email.setToEmail("athirsonarceus@gmail.com");
        email.setFromEmail("athirsonarceus@gmail.com");
        email.setSubjectEmail("Portfolio - Email from: " + emailDTO.getOwnerRef());
        email.setCreatedAt(LocalDateTime.now());

        BeanUtils.copyProperties(emailDTO, email);

        emailService.sendEmail(email);

        if (email.getStatusEmail().equals(StatusEmail.ERROR))
            return new ResponseEntity<>(email, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }
}
