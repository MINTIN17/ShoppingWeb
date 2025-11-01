package com.example.ShoppingWebApi.presentation.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {
    private Long id;
    private UserResponse user;
}
