package com.example.ShoppingWebApi.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "shop")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String avatarUrl;
    private String name;
    private String address;
    private String phone;

    @ManyToOne()
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;
}
