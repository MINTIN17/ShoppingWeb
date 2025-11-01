package com.example.ShoppingWebApi.infrastructure.repository.Jpa;

import com.example.ShoppingWebApi.domain.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaSeller extends JpaRepository<Seller, Long> {
    Optional<Seller> findByUserEmail(String email);
}
