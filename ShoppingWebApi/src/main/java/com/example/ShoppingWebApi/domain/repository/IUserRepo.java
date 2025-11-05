package com.example.ShoppingWebApi.domain.repository;

import com.example.ShoppingWebApi.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepo {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByName(String name);
    List<User> findAllUsers();
}
