package com.example.ShoppingWebApi.domain.entities;

import jakarta.persistence.*;

public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany()
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private float price;
}
