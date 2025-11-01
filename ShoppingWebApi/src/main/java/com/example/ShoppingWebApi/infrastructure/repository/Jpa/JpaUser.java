package com.example.ShoppingWebApi.infrastructure.repository.Jpa;

import com.example.ShoppingWebApi.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUser extends JpaRepository<User, Long> {
}
