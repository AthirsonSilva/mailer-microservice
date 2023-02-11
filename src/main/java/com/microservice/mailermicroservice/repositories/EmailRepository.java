package com.microservice.mailermicroservice.repositories;

import com.microservice.mailermicroservice.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
