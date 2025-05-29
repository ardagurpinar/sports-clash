package com.ardagurpinar.sports_clash.service;

import com.ardagurpinar.sports_clash.dto.UserDTOs.AuthResponse;
import com.ardagurpinar.sports_clash.dto.UserDTOs.CreateUserRequest;
import com.ardagurpinar.sports_clash.dto.UserDTOs.UserDto;
import com.ardagurpinar.sports_clash.dto.UserDTOs.UserResponse;
import com.ardagurpinar.sports_clash.exception.ResourceNotFoundException;
import com.ardagurpinar.sports_clash.model.User;
import com.ardagurpinar.sports_clash.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImplementation(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto createUser(CreateUserRequest req) {
        User user = new User();
        user.setUsername(req.getUsername());
        String encodedPassword = passwordEncoder.encode(req.getPassword());
        user.setPasswordHash(encodedPassword);
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);

        UserDto userDto = modelMapper.map(user, UserDto.class);
        String token = "generated-token" + user.getId();
        userDto.setToken(token);
        return userDto;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUserById(UUID id) {
        User userFromDB = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return modelMapper.map(userFromDB, UserDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUserByUsername(String username) {
        User userFromDB = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        return modelMapper.map(userFromDB, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAllByOrderByTotalPointsDesc().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .toList();
    }

    @Override
    public UserDto touchLastLogin(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        user.setLastLogin(LocalDateTime.now());
        userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }
}
