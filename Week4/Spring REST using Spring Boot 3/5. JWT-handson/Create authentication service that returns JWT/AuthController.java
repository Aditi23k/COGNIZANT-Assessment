package com.cognizant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Base64;

@RestController
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @GetMapping("/authenticate")
    public AuthResponse authenticate(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            throw new RuntimeException("Missing or invalid Authorization header");
        }

        String[] tokens = new String(Base64.getDecoder().decode(authHeader.substring(6))).split(":");
        String username = tokens[0];
        String password = tokens[1];

        if (!("user".equals(username) && "pwd".equals(password))) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(username);
        return new AuthResponse(token);
    }
}
