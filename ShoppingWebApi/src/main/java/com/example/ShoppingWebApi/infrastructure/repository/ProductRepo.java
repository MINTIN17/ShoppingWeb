package com.example.ShoppingWebApi.infrastructure.repository;

import com.example.ShoppingWebApi.domain.entities.Product;
import com.example.ShoppingWebApi.domain.repository.IProductRepo;
import com.example.ShoppingWebApi.infrastructure.repository.Jpa.jpaProduct;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepo implements IProductRepo {
    private final jpaProduct jpaProduct;

    public ProductRepo(jpaProduct jpaProduct) {
        this.jpaProduct = jpaProduct;
    }
    @Override
    public Optional<Product> findProductByName(String name) {
        return jpaProduct.findProductByName(name);
    }
    public List<Product> findAllProducts() {
        return jpaProduct.findAll();
    }


}
