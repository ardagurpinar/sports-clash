package com.ardagurpinar.sports_clash.controller;

import com.ardagurpinar.sports_clash.dto.UserDTOs.AuthResponse;
import com.ardagurpinar.sports_clash.dto.UserDTOs.CreateUserRequest;
import com.ardagurpinar.sports_clash.dto.UserDTOs.UserDto;
import com.ardagurpinar.sports_clash.dto.UserDTOs.UserResponse;
import com.ardagurpinar.sports_clash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest req) {
        UserDto userDto = userService.createUser(req);
        UserResponse response = new UserResponse();
        response.setContent(List.of(userDto));
        return ResponseEntity.ok(response);
    }

//    @GetMapping
//    public ResponseEntity<UserResponse> getAllUsers() {
//        UserResponse userResponse = userService.getAllUsers();
//        return ResponseEntity.ok(userResponse);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID id) {
        UserDto userDto = userService.getUserById(id);
        UserResponse userResponse = new UserResponse();
        userResponse.setContent(List.of(userDto));
        return ResponseEntity.ok(userResponse);
    }
}
