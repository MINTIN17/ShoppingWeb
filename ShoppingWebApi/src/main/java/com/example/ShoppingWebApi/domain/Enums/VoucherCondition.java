package com.example.ShoppingWebApi.domain.Enums;

public enum VoucherCondition {
    ACTIVE("Còn hạn"),
    EXPIRE("Hết hạn"),
    INACTIVE("Chưa được kích hoạt");
    private String displayName;
    private VoucherCondition(String displayName) {
        this.displayName = displayName;
    }

}
