package com.example.ShoppingWebApi.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    private float price;
    private LocalDateTime orderDate;
    private String status; // e.g. "PENDING", "PAID", "SHIPPED", "CANCELLED"
    private String paymentMethod; // e.g. "CASH", "CREDIT_CARD", "MOMO"
}
