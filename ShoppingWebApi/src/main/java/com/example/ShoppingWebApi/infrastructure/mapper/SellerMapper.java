package com.example.ShoppingWebApi.infrastructure.mapper;

import com.example.ShoppingWebApi.domain.entities.Seller;
import com.example.ShoppingWebApi.domain.entities.User;
import com.example.ShoppingWebApi.presentation.dto.response.SellerResponse;
import com.example.ShoppingWebApi.presentation.dto.response.UserResponse;

public class SellerMapper {
    public static SellerResponse toSellerResponse(Seller seller) {
        User user = seller.getUser();

        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhone(user.getPhone());
        userResponse.setGender(user.getGender());
        userResponse.setDateOfBirth(user.getDateOfBirth());
        userResponse.setAvatarUrl(user.getAvatarUrl());
        userResponse.setAddress(user.getAddress());
        userResponse.setEnabled(user.isEnabled());

        SellerResponse sellerResponse = new SellerResponse();
        sellerResponse.setId(seller.getId());
        sellerResponse.setUser(userResponse);

        return sellerResponse;
    }
}
