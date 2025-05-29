package com.ardagurpinar.sports_clash.dto.UserDTOs;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String username;
    private String password;
}
