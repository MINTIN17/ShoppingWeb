package com.example.ShoppingWebApi.infrastructure.repository.Jpa;

import com.example.ShoppingWebApi.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUser extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByName(String name);
}
