package com.microservice.mailermicroservice.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "email")
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String ownerRef;
    private String toEmail;
    private String fromEmail;
    private String subjectEmail;
    @Column(columnDefinition = "TEXT")
    private String bodyEmail;

    private LocalDateTime createdAt;
    private StatusEmail statusEmail;
}
