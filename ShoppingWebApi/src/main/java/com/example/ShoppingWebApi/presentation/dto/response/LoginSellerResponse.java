package com.example.ShoppingWebApi.presentation.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginSellerResponse {
    private String token;
    private SellerResponse sellerResponse;

    public LoginSellerResponse(String token, SellerResponse sellerResponse) {
        this.token = token;
        this.sellerResponse = sellerResponse;
    }
}
