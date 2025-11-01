package com.example.ShoppingWebApi.application.service;

import com.example.ShoppingWebApi.application.service.IService.ISellerService;
import com.example.ShoppingWebApi.domain.entities.Seller;
import com.example.ShoppingWebApi.domain.repository.ISellerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class sellerService implements ISellerService {
    @Autowired
    private ISellerRepo sellerRepo;

}
