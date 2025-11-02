package com.example.ShoppingWebApi.domain.entities;

import com.example.ShoppingWebApi.domain.Enums.VoucherCondition;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@Table(name = "voucher")
@NoArgsConstructor
@AllArgsConstructor
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop ;

    @Enumerated(EnumType.STRING)
    private VoucherCondition voucherCondition;
    private LocalDate  startDate;
    private LocalDate endDate;
    private Long quantity;
    private float percentage;
    private BigDecimal money;

}
