package com.example.ShoppingWebApi.presentation.dto.response;

import com.example.ShoppingWebApi.domain.Enums.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserResponse {
    private String name;
    private String email;
    private String phone;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String avatarUrl;
    private String address;
    private boolean enabled;
}
