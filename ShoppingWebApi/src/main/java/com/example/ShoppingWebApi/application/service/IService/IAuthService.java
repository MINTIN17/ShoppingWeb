package com.example.ShoppingWebApi.application.service.IService;

import com.example.ShoppingWebApi.domain.entities.Customer;
import com.example.ShoppingWebApi.domain.entities.Seller;
import com.example.ShoppingWebApi.domain.entities.User;

import java.util.Optional;

public interface IAuthService {
    Optional<User> CheckAdmin(String email, String password);
    String login(String email, String rawPassword);
    Optional<Customer> findByCustomerEmail(String email);
    Optional<Seller> findBySellerEmail(String email);
}
