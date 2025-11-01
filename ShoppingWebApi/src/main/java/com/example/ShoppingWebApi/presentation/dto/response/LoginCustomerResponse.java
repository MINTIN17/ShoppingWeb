package com.example.ShoppingWebApi.presentation.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCustomerResponse {
    private String token;
    private CustomerResponse customerResponse;

    public LoginCustomerResponse(String token, CustomerResponse customerResponse) {
        this.token = token;
        this.customerResponse = customerResponse;
    }
}
