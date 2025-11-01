package com.example.ShoppingWebApi.application.service.IService;

import com.example.ShoppingWebApi.domain.entities.User;

import java.util.Optional;

public interface IUserService {
    User findByEmail(String email);
}
