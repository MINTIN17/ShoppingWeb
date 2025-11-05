package com.example.ShoppingWebApi.application.service.IService;

import com.example.ShoppingWebApi.domain.entities.Seller;

import java.util.List;
import java.util.Optional;

public interface ISellerService {
    Optional<Seller> findByUserEmail(String email);
    Optional<Seller> findByUserName(String email);
    List<Seller> findAllSellers();
}
