package com.sacral.java.service;

import com.sacral.java.model.User;
import com.sacral.java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User saveUser(User user) {
        // Perform data validation before saving
        if (validateUser(user)) {
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Invalid user data");
        }
    }
    
    private boolean validateUser(User user) {
        // Implement data validation logic here
        // Return true if user data is valid, false otherwise
        return true;
    }
    
    // Add more business methods as per your requirements
    
    // Example: Get user by username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    // Example: Get user by email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // Example: Get user by username and password
    public User getUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
    
    // Example: Get user by email and password
    public User getUserByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
    
    // Example: Get user by username or email
    public User getUserByUsernameOrEmail(String username, String email) {
        return userRepository.findByUsernameOrEmail(username, email);
    }
    
    // Example: Get user by username or email and password
    public User getUserByUsernameOrEmailAndPassword(String username, String email, String password) {
        return userRepository.findByUsernameOrEmailAndPassword(username, email, password);
    }
    
    // Add more methods as per your requirements
}