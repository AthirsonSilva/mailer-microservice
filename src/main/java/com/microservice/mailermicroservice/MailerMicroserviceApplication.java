package com.microservice.mailermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class MailerMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailerMicroserviceApplication.class, args);
    }
}
