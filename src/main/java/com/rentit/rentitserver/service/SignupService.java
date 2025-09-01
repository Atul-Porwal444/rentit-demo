package com.rentit.rentitserver.service;

import com.rentit.rentitserver.entity.UserEntity;
import com.rentit.rentitserver.payload.SignupResponse;
import com.rentit.rentitserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository userRepository;

    public ResponseEntity<?> signup(UserEntity userEntity) {
        try {
            if(userRepository.existsByEmail(userEntity.getEmail())) {
                return new ResponseEntity<>(new SignupResponse("error","Email already exits. Try another email"), HttpStatus.BAD_REQUEST);
            }
            userRepository.save(userEntity);
            return ResponseEntity.ok().body(new SignupResponse("success","Account created successfully"));
        }  catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new SignupResponse("error","Account creation failed"));
        }
    }

}
