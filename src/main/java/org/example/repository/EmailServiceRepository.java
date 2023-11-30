package org.example.repository;

import org.example.model.request.EmailUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmailServiceRepository extends JpaRepository<EmailUser, UUID> {
    Optional<EmailUser> findByEmail(String userEmail);
}
