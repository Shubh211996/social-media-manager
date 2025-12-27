package com.flintzy.social.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flintzy.social.dto.LoginRequest;
import com.flintzy.social.dto.LoginResponse;
import com.flintzy.social.entity.User;
import com.flintzy.social.repository.UserRepository;
import com.flintzy.social.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthController(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseGet(() -> {
                    User u = new User();
                    u.setEmail(request.getEmail());
                    u.setProvider("LOCAL");
                    u.setRole("ADMIN");
                    return userRepository.save(u);
                });

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
        return new LoginResponse(token);
    }
    
    @PostMapping("/facebook")
    public LoginResponse facebookLogin() {

        // Mock Facebook user
        String email = "fb_user@test.com";
        String role = "USER";

        User user = userRepository.findByEmail(email)
                .orElseGet(() -> {
                    User u = new User();
                    u.setEmail(email);
                    u.setProvider("FACEBOOK");
                    u.setRole(role);
                    return userRepository.save(u);
                });

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
        return new LoginResponse(token);
    }

}
