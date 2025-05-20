package com.ardagurpinar.sports_clash.controller;

import com.ardagurpinar.sports_clash.dto.UserDto;
import com.ardagurpinar.sports_clash.dto.UserResponse;
import com.ardagurpinar.sports_clash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
        UserDto newUser = userService.registerUser(userDto);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping
    public ResponseEntity<UserResponse> getAllUsers() {
        UserResponse userResponse = userService.getAllUsers();
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        UserResponse userResponse = userService.getUserById(id);
        return ResponseEntity.ok(userResponse);
    }
}
