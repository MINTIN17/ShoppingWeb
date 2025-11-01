package com.example.ShoppingWebApi.domain.entities;

import jakarta.persistence.*;

public class Order_item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private int quantity;
}
