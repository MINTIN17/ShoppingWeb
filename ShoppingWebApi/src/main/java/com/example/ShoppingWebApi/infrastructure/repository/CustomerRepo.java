package com.example.ShoppingWebApi.infrastructure.repository;

import com.example.ShoppingWebApi.domain.entities.Customer;
import com.example.ShoppingWebApi.domain.repository.ICustomerRepo;
import com.example.ShoppingWebApi.infrastructure.repository.Jpa.JpaCustomer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomerRepo implements ICustomerRepo {
    private final JpaCustomer jpaCustomer;

    public CustomerRepo(JpaCustomer jpaCustomer) {
        this.jpaCustomer = jpaCustomer;
    }

    @Override
    public Optional<Customer> findByUserEmail(String email) {
        return jpaCustomer.findByUserEmail(email);
    }

    @Override
    public Customer Save(Customer customer) {
        return jpaCustomer.save(customer);
    }
}
