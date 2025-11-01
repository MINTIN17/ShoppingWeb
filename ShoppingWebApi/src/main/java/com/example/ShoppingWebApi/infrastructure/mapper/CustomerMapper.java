package com.example.ShoppingWebApi.infrastructure.mapper;

import com.example.ShoppingWebApi.domain.entities.Customer;
import com.example.ShoppingWebApi.domain.entities.Seller;
import com.example.ShoppingWebApi.domain.entities.User;
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
}
