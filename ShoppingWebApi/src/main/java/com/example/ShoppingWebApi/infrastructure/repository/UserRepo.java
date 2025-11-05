package com.example.ShoppingWebApi.infrastructure.repository;

import com.example.ShoppingWebApi.domain.entities.User;
import com.example.ShoppingWebApi.domain.repository.IUserRepo;
import com.example.ShoppingWebApi.infrastructure.repository.Jpa.JpaUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepo implements IUserRepo {
    private final JpaUser jpaUser;

    public UserRepo(JpaUser jpaUser) {
        this.jpaUser = jpaUser;
    }

    public Optional<User> findUserByEmail(String email) {
        return jpaUser.findByEmail(email);
    }
    public Optional<User> findUserByName(String name) {
        return jpaUser.findByName(name);
    }
    @Override
    public List<User> findAllUsers() {
        return jpaUser.findAll();
    }
}
