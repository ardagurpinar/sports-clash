package com.ardagurpinar.sports_clash.service;

import com.ardagurpinar.sports_clash.dto.UserDTOs.AuthResponse;
import com.ardagurpinar.sports_clash.dto.UserDTOs.CreateUserRequest;
import com.ardagurpinar.sports_clash.dto.UserDTOs.UserDto;
import com.ardagurpinar.sports_clash.dto.UserDTOs.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserDto createUser(CreateUserRequest req);
    UserDto getUserById(UUID id);
    UserDto getUserByUsername(String username);
    List<UserDto> getAllUsers();
    UserDto touchLastLogin(UUID id);

}
