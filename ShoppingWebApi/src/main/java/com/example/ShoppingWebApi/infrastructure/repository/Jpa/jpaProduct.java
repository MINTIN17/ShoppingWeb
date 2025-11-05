package com.example.ShoppingWebApi.infrastructure.repository.Jpa;

import com.example.ShoppingWebApi.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface jpaProduct extends JpaRepository<Product, Long> {
    Optional<Product> findProductByName(String name);
}
