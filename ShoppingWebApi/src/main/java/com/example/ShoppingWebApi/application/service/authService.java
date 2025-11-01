package com.example.ShoppingWebApi.application.service;

import com.example.ShoppingWebApi.application.service.IService.IAuthService;
import com.example.ShoppingWebApi.domain.entities.Customer;
import com.example.ShoppingWebApi.domain.entities.Seller;
import com.example.ShoppingWebApi.domain.entities.User;
import com.example.ShoppingWebApi.domain.repository.ICustomerRepo;
import com.example.ShoppingWebApi.domain.repository.ISellerRepo;
import com.example.ShoppingWebApi.domain.repository.IUserRepo;
import com.example.ShoppingWebApi.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class authService implements IAuthService {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private ICustomerRepo customerRepo;

    @Autowired
    private ISellerRepo sellerRepo;

    public Optional<User> CheckAdmin(String email, String password) {
        Optional<User> userOpt = userRepo.findByEmail(email);

        if (userOpt.isPresent()) {
            User user = userOpt.get();

            if (passwordEncoder.matches(password, user.getPassword()) && "ADMIN".equalsIgnoreCase(String.valueOf(user.getRole()))) {
                return Optional.of(user);
            }

        }
        return Optional.empty();
    }

    public String login(String email, String rawPassword) {
        Optional<User> user = userRepo.findByEmail(email);

        if (user.isEmpty()) {
            throw new RuntimeException("Email không tồn tại");
        }

        if (!passwordEncoder.matches(rawPassword, user.get().getPassword())) {
            throw new RuntimeException("Sai mật khẩu");
        }

        return jwtUtil.generateToken(email, user.get().getRole());
    }

    public Optional<Customer> findByCustomerEmail(String email) {
        return customerRepo.findByUserEmail(email);
    }

    @Override
    public Optional<Seller> findBySellerEmail(String email) {
        return sellerRepo.findByUserEmail(email);
    }
}
