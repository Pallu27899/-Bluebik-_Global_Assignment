package com.Bankapp.Controller;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bankapp.Entity.User;
import com.Bankapp.Repository.UserRepository;

@RestController
public class UserController {
	private final AtomicLong userIdGenerator = new AtomicLong(0);
	
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        // Validate user input
        if (user.getName() == null || user.getName().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Set user ID and save to database
        Long userId = userIdGenerator.incrementAndGet();
        user.setUserId(userId);
        userRepository.save(user);

        userRepository.save(user);

        // Return HTTP 201 Created with user data in response body
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}

