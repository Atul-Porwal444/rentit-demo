package com.rentit.rentitserver.controller;

import com.rentit.rentitserver.payload.SavePostRequest;
import com.rentit.rentitserver.service.SavePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class SavePostController {

    private final SavePostService savePostService;

    @PostMapping("/savepost")
    public ResponseEntity<?> savePost(@RequestBody SavePostRequest savePostRequest) {
        return savePostService.savePost(savePostRequest);
    }
}
