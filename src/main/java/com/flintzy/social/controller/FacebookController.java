package com.flintzy.social.controller;

import com.flintzy.social.dto.FacebookPostRequest;
import com.flintzy.social.dto.LoginResponse;
import com.flintzy.social.entity.User;
import com.flintzy.social.repository.UserRepository;
import com.flintzy.social.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/facebook")
public class FacebookController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public FacebookController(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    // MOCK FACEBOOK LOGIN
    @PostMapping("/connect")
    public LoginResponse connectFacebook() {

        String email = "fb_user@test.com";

        User user = userRepository.findByEmail(email)
                .orElseGet(() -> {
                    User u = new User();
                    u.setEmail(email);
                    u.setRole("USER");
                    u.setProvider("FACEBOOK");
                    return userRepository.save(u);
                });

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
        return new LoginResponse(token);
    }

    // MOCK POST TO FACEBOOK
    @PostMapping("/post")
    public String postToFacebook(@RequestBody FacebookPostRequest request) {
        return "Post published successfully to Facebook page: " + request.getPageId();
    }
}
