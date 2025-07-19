package com.example.backend.controller;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.LoginRequest;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginRequest request) {
    System.out.println("[DEBUG] Login request: " + request.getIdentifier() + ", role: " + request.getRole());

    Optional<User> userOpt = userRepository.findByIdentifier(request.getIdentifier());

    if (userOpt.isPresent()) {
        User user = userOpt.get();
        System.out.println("[DEBUG] Found user: " + user.getIdentifier() + ", role in DB: " + user.getRole());

        if (!user.getPassword().equals(request.getPassword())) {
            System.out.println("[DEBUG] Password mismatch");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
        }

        if (!user.getRole().trim().equalsIgnoreCase(request.getRole().trim())) {
            System.out.println("[DEBUG] Role mismatch. Expected: [" + user.getRole() + "], Got: [" + request.getRole() + "]");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Role mismatch");
        }

        Map<String, Object> response = new HashMap<>();
response.put("name", user.getName());
response.put("role", user.getRole());
response.put("identifier", user.getIdentifier());
return ResponseEntity.ok(response);
    } else {
        System.out.println("[DEBUG] User not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}

}
