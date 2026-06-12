package com.notes.backend.service;


import com.notes.backend.dto.request.CreateUserRequest;
import com.notes.backend.dto.response.UserResponse;
import com.notes.backend.entity.User;
import com.notes.backend.exception.BadRequestException;
import com.notes.backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse createUser(CreateUserRequest request){
        if (userRepository.existsByEmail(request.email())){
            throw new BadRequestException("Email is alredy used");
        }
        User user = new User();
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));

        User savedUser = userRepository.save(user);

        return toUserResponse(savedUser);
    }

    public List<UserResponse> getAllUsers(){
        return  userRepository.findAll()
                .stream()
                .map(this::toUserResponse)
                .toList();
    }

    public  UserResponse getUserById(String id){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));

        return toUserResponse(user);
    }

    private UserResponse toUserResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }

}
