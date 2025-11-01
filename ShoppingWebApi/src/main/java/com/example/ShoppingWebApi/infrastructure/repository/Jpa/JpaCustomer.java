package com.example.ShoppingWebApi.infrastructure.repository.Jpa;

import com.example.ShoppingWebApi.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaCustomer extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUserEmail(String email);
}
