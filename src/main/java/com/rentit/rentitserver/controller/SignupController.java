package com.rentit.rentitserver.controller;

import com.rentit.rentitserver.entity.UserEntity;
import com.rentit.rentitserver.service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class SignupController {

    private final SignupService signupService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserEntity userEntity) {
        return signupService.signup(userEntity);
    }
}
