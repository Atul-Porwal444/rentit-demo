package com.rentit.rentitserver.controller;

import com.rentit.rentitserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @DeleteMapping("/deleteuser")
    public ResponseEntity<?> delete(@RequestParam Long userId) {
        return userService.delete(userId);
    }
}
