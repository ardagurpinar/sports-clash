package com.ardagurpinar.sports_clash.security;

import com.ardagurpinar.sports_clash.model.User;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JWTService {
    @Value("${application.security.jwt.secret-key}")
    private String secretKey;

    @Value("${application.security.jwt.expiration}")
    private long expiration;

    public String generateToken(AuthUserDetails authUserDetails) {
        System.out.println("New Date w/ System.currentTimeMillis" + new Date(System.currentTimeMillis()));
        System.out.println("New Date" + new Date());
        return Jwts.builder()
                .subject(authUserDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSecretKey())
                .compact();
    }

    public boolean validateToken(String token,  AuthUserDetails authUserDetails) {
        try {
            if (isTokenExpired(token)) {
                return false;
            }
            String username = authUserDetails.getUsername();
            return username.equals(extractUsername(token));

        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }

    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean isTokenExpired(String token) {
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getExpiration().before(new Date());

    }

    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
}
