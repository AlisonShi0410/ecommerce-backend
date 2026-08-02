package com.ecommerce.controller;

import com.ecommerce.dto.CreateUserRequest;
import com.ecommerce.entity.User;
import com.ecommerce.service.UserSerivce;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/users")
public class UserController {
    private final UserSerivce userSerivce;

    public UserController(UserSerivce userSerivce){
        this.userSerivce = userSerivce;
    }

    // controller -> DTO -> service -> repository
    @PostMapping
    public User createUser(@RequestBody CreateUserRequest request){
        return userSerivce.createUser(request);
    }
}
