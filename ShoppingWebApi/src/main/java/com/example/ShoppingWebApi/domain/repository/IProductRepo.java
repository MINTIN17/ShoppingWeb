package com.example.ShoppingWebApi.domain.repository;

import com.example.ShoppingWebApi.domain.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepo {
    Optional<Product> findProductByName(String name);
    List<Product> findAllProducts();
}
