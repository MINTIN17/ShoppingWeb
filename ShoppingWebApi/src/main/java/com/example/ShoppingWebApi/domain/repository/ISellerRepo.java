package com.example.ShoppingWebApi.domain.repository;

import com.example.ShoppingWebApi.domain.entities.Seller;

import java.util.List;
import java.util.Optional;

public interface ISellerRepo {
    Optional<Seller> findByUserEmail(String email);
    Optional<Seller> findByUserName(String email);
    List<Seller> findAllSellers();
}
