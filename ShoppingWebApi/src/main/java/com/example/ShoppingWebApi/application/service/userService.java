package com.example.ShoppingWebApi.application.service;

import com.example.ShoppingWebApi.application.service.IService.IUserService;
import com.example.ShoppingWebApi.domain.entities.User;
import com.example.ShoppingWebApi.domain.repository.IUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class userService implements IUserService {
    @Autowired
    private IUserRepo userRepo;

    @Override
    public User findByEmail(String email) {
        Optional<User> user = userRepo.findByEmail(email);
        return user.orElse(null);
    }
}
