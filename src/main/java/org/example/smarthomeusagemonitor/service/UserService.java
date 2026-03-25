package com.example.demo.service;

import com.example.demo.DTOs.UserDTO;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(Long userId){
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(Long userId, UserDTO request){

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        if(request.getName() != null ) user.setName(request.getName());
        if(request.getEmail() != null ) user.setEmail(request.getEmail());

        return userRepository.save(user);
    }

    public void deleteUserById(Long userId){
        userRepository.deleteById(userId);
    }
}
