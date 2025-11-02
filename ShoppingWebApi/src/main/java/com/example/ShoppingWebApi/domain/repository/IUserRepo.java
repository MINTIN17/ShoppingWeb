package com.example.ShoppingWebApi.domain.repository;

import com.example.ShoppingWebApi.domain.entities.User;

import java.util.Optional;

public interface IUserRepo {
    Optional<User> findByEmail(String email);
    
}
