package com.example.ShoppingWebApi.infrastructure.repository;

import com.example.ShoppingWebApi.domain.repository.IUserRepo;
import com.example.ShoppingWebApi.infrastructure.repository.Jpa.JpaUser;
import org.springframework.stereotype.Repository;

@Repository
public class UseRepo implements IUserRepo {
    private final JpaUser jpaUser;

    public UseRepo(JpaUser jpaUser) {
        this.jpaUser = jpaUser;
    }


}
