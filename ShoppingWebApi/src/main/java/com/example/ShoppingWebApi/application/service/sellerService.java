package com.example.ShoppingWebApi.application.service;

import com.example.ShoppingWebApi.application.service.IService.ISellerService;
import com.example.ShoppingWebApi.domain.entities.Seller;
import com.example.ShoppingWebApi.domain.repository.ISellerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class sellerService implements ISellerService {
    private final ISellerRepo sellerRepo;

    public sellerService(ISellerRepo sellerRepo) {
        this.sellerRepo = sellerRepo;
    }

    @Override
    public Optional<Seller> findByUserEmail(String email) {
        return sellerRepo.findByUserEmail(email);
    }

    @Override
    public Optional<Seller> findByUserName(String email) {
        return sellerRepo.findByUserName(email);
    }

    @Override
    public List<Seller> findAllSellers() {
        return sellerRepo.findAllSellers();
    }
}
