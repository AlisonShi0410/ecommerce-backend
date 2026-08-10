package com.ecommerce.controller;

import com.ecommerce.dto.CreateUserRequest;
import com.ecommerce.dto.LoginRequest;
import com.ecommerce.entity.User;
import com.ecommerce.service.UserService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    // controller -> DTO -> service -> repository
    @PostMapping("/register")
    public User createUser(@Valid @RequestBody CreateUserRequest request){
        return userService.register(request);
    }

    @PostMapping("/login")
    public User login(@Valid @RequestBody LoginRequest request){
        return userService.login(request);
    }
}
