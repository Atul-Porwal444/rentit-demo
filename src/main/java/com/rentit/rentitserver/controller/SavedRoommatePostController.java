package com.rentit.rentitserver.controller;

import com.rentit.rentitserver.payload.SavedRoommatePostRequest;
import com.rentit.rentitserver.service.SavedRoommatePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class SavedRoommatePostController {
    private final SavedRoommatePostService savedRoommatePostService;

    @PostMapping("/saveroommatepost")
    public ResponseEntity<?> saveRoommatePost(@RequestBody SavedRoommatePostRequest savedRoommatePostRequest) {
        return savedRoommatePostService.saveRoommatePost(savedRoommatePostRequest);
    }
}
