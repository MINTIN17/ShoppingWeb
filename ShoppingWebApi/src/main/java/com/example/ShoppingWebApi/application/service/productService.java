package com.example.ShoppingWebApi.application.service;

import com.example.ShoppingWebApi.application.service.IService.IProductService;
import com.example.ShoppingWebApi.domain.entities.Product;
import com.example.ShoppingWebApi.domain.entities.User;
import com.example.ShoppingWebApi.domain.repository.IProductRepo;
import com.example.ShoppingWebApi.domain.repository.IUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productService implements IProductService {
    private final IProductRepo productRepo;

    public productService(IProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        return productRepo.findProductByName(name);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepo.findAllProducts();
    }
}
