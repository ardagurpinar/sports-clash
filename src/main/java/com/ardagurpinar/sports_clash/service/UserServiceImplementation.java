package com.ardagurpinar.sports_clash.service;

import com.ardagurpinar.sports_clash.dto.UserDto;
import com.ardagurpinar.sports_clash.dto.UserResponse;
import com.ardagurpinar.sports_clash.exception.ResourceNotFoundException;
import com.ardagurpinar.sports_clash.model.User;
import com.ardagurpinar.sports_clash.repository.UserRepository;
import org.modelmapper.ModelMapper;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public UserServiceImplementation(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public UserDto registerUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        String passwordHash = userDto.getPassword() + "hashed";
        user.setPasswordHash(passwordHash);
        userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserResponse getAllUsers() {
        List<User> users = userRepository.findAll();
        System.out.println("users: " + users);
        List<UserDto> userDtos = users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .toList();

        UserResponse userResponse = new UserResponse();
        userResponse.setContent(userDtos);

        return userResponse;
    }

    @Override
    public UserResponse getUserById(Long id) {
        User userFromDB = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        UserDto userDto = modelMapper.map(userFromDB, UserDto.class);
        UserResponse userResponse = new UserResponse();
        userResponse.setContent(List.of(userDto));
        return userResponse;
    }

//    private PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
}
