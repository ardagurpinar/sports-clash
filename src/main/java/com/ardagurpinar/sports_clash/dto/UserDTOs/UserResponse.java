package com.ardagurpinar.sports_clash.dto.UserDTOs;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private List<UserDto> content;
}
