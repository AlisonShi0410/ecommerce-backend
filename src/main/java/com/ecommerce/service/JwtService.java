package com.ecommerce.service;

import com.ecommerce.config.JwtConfig;
import com.ecommerce.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {
    private final JwtConfig jwtConfig;

    public JwtService(JwtConfig jwtConfig){
        this.jwtConfig = jwtConfig;
    }

    // JWT 要根据这个 User 生成一个 Token。
    public String generateToken(User user){
        SecretKey key = Keys.hmacShaKeyFor(jwtConfig.getSecret().getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .subject(user.getEmail())
                .expiration(new Date(System.currentTimeMillis()+ jwtConfig.getExpiration()))
                .issuedAt(new Date())
                .signWith(key)
                .compact();
    }

    public String extractEmail(String token){

    }

    public boolean isTokenValid(String token){

    }
}
