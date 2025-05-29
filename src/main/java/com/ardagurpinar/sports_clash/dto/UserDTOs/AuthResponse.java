package com.ardagurpinar.sports_clash.dto.UserDTOs;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;
    private UserDto user;
}
