package com.example.ShoppingWebApi.infrastructure.repository;

import com.example.ShoppingWebApi.domain.entities.User;
import com.example.ShoppingWebApi.domain.repository.IUserRepo;
import com.example.ShoppingWebApi.infrastructure.repository.Jpa.JpaUser;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UseRepo implements IUserRepo {
    private final JpaUser jpaUser;

    public UseRepo(JpaUser jpaUser) {
        this.jpaUser = jpaUser;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaUser.findByEmail(email);
    }
}
