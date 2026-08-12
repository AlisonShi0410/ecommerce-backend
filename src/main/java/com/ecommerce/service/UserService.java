package com.ecommerce.service;

import com.ecommerce.dto.CreateUserRequest;
import com.ecommerce.dto.LoginRequest;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    /*
    public User createUser(User user){
        return userRepository.save(user);
    }
    如果是用这个的话，为啥不用创建user对象，就是this一下这个user？
    No:因为之前controller已经创建好了user，spring收到JSON会自动创建user对象
     */

    //但是现在Controller给的是DTO，所以要自己创建要从 DTO->Entiry
    public User register(CreateUserRequest request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exist");
        }
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        return userRepository.save(user);
    }

    /*
    public String login(LoginRequest request){
        User user= userRepository.findByEmail(request.getEmail())
                .orElseThrow(()->new RuntimeException("Invalid email or password"));

        if(!passwordEncoder.matches(request.getPassword(),user.getPasswordHash())){
            throw new RuntimeException("Invalid email or password");
        }
        return jwtService.generateToken(user);
    }*/
    // 练习⬇️
    public String login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(()-> new RuntimeException("Invalid email"));
        if(!passwordEncoder.matches(request.getPassword(),user.getPasswordHash())){
            throw new RuntimeException("Invalid Email or Password");
        }
        return jwtService.generateToken(user);
    }

}

