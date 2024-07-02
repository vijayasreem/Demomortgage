package com.sacral.java.controller;

import com.sacral.java.model.User;
import com.sacral.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        try {
            User savedUser = userService.saveUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Add more endpoints as per your requirements

    // Example: Get user by username
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Example: Get user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Example: Get user by username and password
    @GetMapping("/username/{username}/password/{password}")
    public ResponseEntity<User> getUserByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
        User user = userService.getUserByUsernameAndPassword(username, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Example: Get user by email and password
    @GetMapping("/email/{email}/password/{password}")
    public ResponseEntity<User> getUserByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
        User user = userService.getUserByEmailAndPassword(email, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Example: Get user by username or email
    @GetMapping("/username/{username}/email/{email}")
    public ResponseEntity<User> getUserByUsernameOrEmail(@PathVariable String username, @PathVariable String email) {
        User user = userService.getUserByUsernameOrEmail(username, email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Example: Get user by username or email and password
    @GetMapping("/username/{username}/email/{email}/password/{password}")
    public ResponseEntity<User> getUserByUsernameOrEmailAndPassword(@PathVariable String username, @PathVariable String email, @PathVariable String password) {
        User user = userService.getUserByUsernameOrEmailAndPassword(username, email, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add more endpoints as per your requirements
}