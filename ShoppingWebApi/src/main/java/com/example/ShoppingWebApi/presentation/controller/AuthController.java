package com.example.ShoppingWebApi.presentation.controller;

import com.example.ShoppingWebApi.application.service.IService.IAuthService;
import com.example.ShoppingWebApi.application.service.IService.IUserService;
import com.example.ShoppingWebApi.domain.Enums.Role;
import com.example.ShoppingWebApi.domain.entities.Customer;
import com.example.ShoppingWebApi.domain.entities.Seller;
import com.example.ShoppingWebApi.domain.entities.User;
import com.example.ShoppingWebApi.infrastructure.mapper.CustomerMapper;
import com.example.ShoppingWebApi.infrastructure.mapper.SellerMapper;
import com.example.ShoppingWebApi.infrastructure.security.JwtUtil;
import com.example.ShoppingWebApi.presentation.dto.request.LoginRequest;
import com.example.ShoppingWebApi.presentation.dto.response.CustomerResponse;
import com.example.ShoppingWebApi.presentation.dto.response.LoginCustomerResponse;
import com.example.ShoppingWebApi.presentation.dto.response.LoginSellerResponse;
import com.example.ShoppingWebApi.presentation.dto.response.SellerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtUtil jwtUtil;
    private final IAuthService authService;
    private final IUserService userService;

    public AuthController(JwtUtil jwtUtil, IAuthService authService, IUserService userService) {
        this.jwtUtil = jwtUtil;
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            Optional<User> userOpt = authService.CheckAdmin(request.getEmail(), request.getPassword());
            if (userOpt.isPresent()) {
                User user = userOpt.get();
                String token = jwtUtil.generateToken(request.getEmail(), user.getRole());

                Map<String, String> response = new HashMap<>();
                response.put("token", token);

                return ResponseEntity.ok(response);
            }

            String token = authService.login(request.getEmail(), request.getPassword());
            User user = userService.findByEmail(request.getEmail());
            if (user.getRole() == Role.CUSTOMER) {
                Customer customer = authService.findByCustomerEmail(request.getEmail())
                        .orElseThrow(() -> new RuntimeException("Patient not found"));
                CustomerResponse customerResponse = CustomerMapper.toCustomerResponse(customer);
                return ResponseEntity.ok(new LoginCustomerResponse(token, customerResponse));
            }
            Seller doctor = authService.findBySellerEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("Doctor not found"));
            SellerResponse doctorResponse = SellerMapper.toSellerResponse(doctor);
            return ResponseEntity.ok(new LoginSellerResponse(token, doctorResponse));

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
