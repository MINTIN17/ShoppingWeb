package com.example.ShoppingWebApi.infrastructure.repository;

import com.example.ShoppingWebApi.domain.entities.Seller;
import com.example.ShoppingWebApi.domain.repository.ISellerRepo;
import com.example.ShoppingWebApi.infrastructure.repository.Jpa.JpaCustomer;
import com.example.ShoppingWebApi.infrastructure.repository.Jpa.JpaSeller;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SellerRepo implements ISellerRepo {
    private final JpaSeller jpaSeller;

    public SellerRepo(JpaSeller jpaSeller) {
        this.jpaSeller = jpaSeller;
    }

    @Override
    public Optional<Seller> findByUserEmail(String email) {
        return jpaSeller.findByUserEmail(email);
    }
}
