package com.microservice.mailermicroservice.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDTO {
    @NotBlank
    private String ownerRef;
    @NotBlank
    @Email
    private String toEmail;
    @NotBlank
    @Email
    private String fromEmail;
    @NotBlank
    private String subjectEmail;
    @NotBlank
    private String bodyEmail;
}
