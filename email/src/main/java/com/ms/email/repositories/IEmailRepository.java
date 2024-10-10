package com.ms.email.repositories;

import com.ms.email.model.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface IEmailRepository extends JpaRepository<EmailModel, UUID> {
}
