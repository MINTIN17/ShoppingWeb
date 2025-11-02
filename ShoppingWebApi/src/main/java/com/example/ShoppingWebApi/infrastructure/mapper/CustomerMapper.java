package com.example.ShoppingWebApi.infrastructure.mapper;

import com.example.ShoppingWebApi.domain.Enums.Role;
import com.example.ShoppingWebApi.domain.entities.Customer;
import com.example.ShoppingWebApi.domain.entities.Seller;
import com.example.ShoppingWebApi.domain.entities.User;
import com.example.ShoppingWebApi.presentation.dto.request.RegisterRequest;
import com.example.ShoppingWebApi.presentation.dto.response.CustomerResponse;
import com.example.ShoppingWebApi.presentation.dto.response.SellerResponse;
import com.example.ShoppingWebApi.presentation.dto.response.UserResponse;

public class CustomerMapper {
    public static CustomerResponse toCustomerResponse(Customer customer) {
        User user = customer.getUser();

        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhone(user.getPhone());
        userResponse.setGender(user.getGender());
        userResponse.setDateOfBirth(user.getDateOfBirth());
        userResponse.setAvatarUrl(user.getAvatarUrl());
        userResponse.setAddress(user.getAddress());
        userResponse.setEnabled(user.isEnabled());

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setId(customer.getId());
        customerResponse.setUser(userResponse);

        return customerResponse;
    }

    public static Customer toCustomer(RegisterRequest registerRequest) {
        User user = User.builder()
                .name(registerRequest.getName())
                .email(registerRequest.getEmail())
                .password(registerRequest.getPassword())
                .phone(registerRequest.getPhone())
                .gender(registerRequest.getGender())
                .dateOfBirth(registerRequest.getDateOfBirth())
                .avatarUrl("https://res.cloudinary.com/di53bdbjf/image/upload/v1746346822/hospital_appointment/avatar_jam4xb.png")
                .address(registerRequest.getAddress())
                .role(Role.CUSTOMER)
                .enabled(true)
                .deleted(false)
                .build();

        return Customer.builder().user(user).build();
    }
}
