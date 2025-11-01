package com.example.ShoppingWebApi.domain.entities;

import jakarta.persistence.*;

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    private float price;
}
