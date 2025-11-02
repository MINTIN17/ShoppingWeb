package com.example.ShoppingWebApi.domain.repository;

import com.example.ShoppingWebApi.domain.entities.Customer;

import java.util.Optional;

public interface ICustomerRepo {
    Optional<Customer>  findByUserEmail(String email);
    Customer Save(Customer customer);
}
