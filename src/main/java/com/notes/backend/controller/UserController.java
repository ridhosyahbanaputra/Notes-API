package com.notes.backend.controller;


import com.notes.backend.dto.request.CreateUserRequest;
import com.notes.backend.dto.response.ApiResponse;
import com.notes.backend.dto.response.UserResponse;
import com.notes.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public  UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ApiResponse<UserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        UserResponse user = userService.createUser(request);

        return new ApiResponse<>(
                "success",
                "User created successfully",
                user
        );
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userService.getAllUsers();

        return new ApiResponse<>(
                "success",
                "Users retrieved successfully",
                users
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUserById(@PathVariable String id) {
        UserResponse user = userService.getUserById(id);

        return new ApiResponse<>(
                "success",
                "User retrieved successfully",
                user
        );
    }
}

