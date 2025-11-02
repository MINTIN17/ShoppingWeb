package com.example.ShoppingWebApi.application.service.IService;

import com.example.ShoppingWebApi.domain.entities.Customer;
import com.example.ShoppingWebApi.domain.entities.Seller;
import com.example.ShoppingWebApi.domain.entities.User;
import com.example.ShoppingWebApi.presentation.dto.request.RegisterRequest;

import java.util.Optional;

public interface IAuthService {
    Optional<User> CheckAdmin(String email, String password);
    String login(String email, String rawPassword);
    Customer register(RegisterRequest registerRequest);
    Optional<Customer> findByCustomerEmail(String email);
    Optional<Seller> findBySellerEmail(String email);
}
