package com.ardagurpinar.sports_clash.service;

import com.ardagurpinar.sports_clash.dto.UserDto;
import com.ardagurpinar.sports_clash.dto.UserResponse;
import com.ardagurpinar.sports_clash.repository.UserRepository;

public interface UserService {

    UserDto registerUser(UserDto userDto);

    UserResponse getAllUsers();

    UserResponse getUserById(Long id);
}
