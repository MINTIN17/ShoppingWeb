package com.example.ShoppingWebApi.domain.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String avatarUrl;
    private String name;
    private String address;
    private String phone;

    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;
}
