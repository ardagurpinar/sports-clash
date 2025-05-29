package com.ardagurpinar.sports_clash.dto.UserDTOs;

import lombok.Data;

@Data
public class LoginUserRequest {
    private String username;
    private String password;
}
