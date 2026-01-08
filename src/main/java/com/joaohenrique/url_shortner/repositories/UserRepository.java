package com.joaohenrique.url_shortner.repositories;

import com.joaohenrique.url_shortner.entities.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Email> {
    Optional<User> findByEmail(String email);
    Optional<User> findById(String username);
}
