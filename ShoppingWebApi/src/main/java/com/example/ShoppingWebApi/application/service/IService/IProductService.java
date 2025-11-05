package com.example.ShoppingWebApi.application.service.IService;

import com.example.ShoppingWebApi.domain.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Optional<Product> findProductByName(String name);
    List<Product> findAllProducts();
}
