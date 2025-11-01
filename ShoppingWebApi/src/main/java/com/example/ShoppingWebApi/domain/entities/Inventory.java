package com.example.ShoppingWebApi.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "inventory")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    LocalTime date;
    private int received;
    private int sold;
    private int stock;
}
