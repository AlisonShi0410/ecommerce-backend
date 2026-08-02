package com.ecommerce.service;

import com.ecommerce.dto.CreateUserRequest;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserSerivce {
    private final UserRepository userRepository;

    public UserSerivce(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /*
    public User createUser(User user){
        return userRepository.save(user);
    }
     */

    public User createUser(CreateUserRequest request){
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPasswordHash(request.getPassword());
        user.setPhone(request.getPhone());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        return userRepository.save(user);
    }
}
