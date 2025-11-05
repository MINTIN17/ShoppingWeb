package com.example.ShoppingWebApi.application.service;

import com.example.ShoppingWebApi.application.service.IService.IUserService;
import com.example.ShoppingWebApi.domain.entities.User;
import com.example.ShoppingWebApi.domain.repository.IUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class userService implements IUserService {

    private final IUserRepo userRepo;

    public userService(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }

    @Override
    public Optional<User> findByName(String name) {
        return userRepo.findUserByName(name);
    }
    @Override
    public List<User> findAllUsers() {
        return userRepo.findAllUsers();
    }
}
