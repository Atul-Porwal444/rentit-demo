package com.rentit.rentitserver.service;

import com.rentit.rentitserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public ResponseEntity<?> delete(Long userId) {
        try {
            if(userRepository.existsById(userId)) {
                userRepository.deleteById(userId);
                return ResponseEntity.ok("User has been deleted");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!");
        }
    }
}
