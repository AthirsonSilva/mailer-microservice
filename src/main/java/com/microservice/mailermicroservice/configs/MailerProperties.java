package com.microservice.mailermicroservice.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("mailer")
@Data
public class MailerProperties {
    private String emailAddress;
    private String emailPassword;
    private String databaseUrl;
    private String databaseUsername;
    private String databasePassword;
}
