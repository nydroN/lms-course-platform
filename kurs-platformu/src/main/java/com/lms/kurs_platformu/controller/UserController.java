package com.lms.kurs_platformu.controller;

import com.lms.kurs_platformu.dto.UserResponseDto;
import com.lms.kurs_platformu.entity.User;
import com.lms.kurs_platformu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            UserResponseDto savedUserDto = userService.registerUser(user);
            return ResponseEntity.ok(savedUserDto);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody com.lms.kurs_platformu.dto.LoginRequestDto loginRequest) {
        try {
            String token = userService.login(loginRequest);
            return ResponseEntity.ok(token);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}