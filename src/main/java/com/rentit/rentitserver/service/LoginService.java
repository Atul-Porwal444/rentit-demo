package com.rentit.rentitserver.service;

import com.rentit.rentitserver.payload.LoginRequest;
import com.rentit.rentitserver.payload.LoginResponse;
import com.rentit.rentitserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;

    public ResponseEntity<?> login(LoginRequest loginRequest) {
        try {
            if(userRepository.existsByEmail(loginRequest.getEmail()) && userRepository.findByEmail(loginRequest.getEmail()).getPassword().equals(loginRequest.getPassword())) {
                return ResponseEntity.ok(new LoginResponse("success","Login successful! Here is your JWT token!"));
            }
            return new ResponseEntity<>(new LoginResponse("error","Invalid username or password!"), HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new LoginResponse("error","Something went wrong on the server!"));
        }
    }
}
