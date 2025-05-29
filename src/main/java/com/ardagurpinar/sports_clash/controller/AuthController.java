package com.ardagurpinar.sports_clash.controller;

import com.ardagurpinar.sports_clash.dto.UserDTOs.AuthResponse;
import com.ardagurpinar.sports_clash.dto.UserDTOs.LoginUserRequest;
import com.ardagurpinar.sports_clash.security.AuthUserDetails;
import com.ardagurpinar.sports_clash.security.AuthUserDetailsService;
import com.ardagurpinar.sports_clash.security.JWTService;
import com.ardagurpinar.sports_clash.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthUserDetailsService authUserDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public AuthController(AuthUserDetailsService authUserDetailsService, AuthenticationManager authenticationManager, JWTService jwtService) {
        this.authUserDetailsService = authUserDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginUserRequest req) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));

        AuthUserDetails authUserDetails = authUserDetailsService.loadUserByUsername(req.getUsername());
        String token = jwtService.generateToken(authUserDetails);

        AuthResponse response = new AuthResponse();

        response.setToken(token);
        return ResponseEntity.ok(response);
    }
}
