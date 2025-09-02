package com.rentit.rentitserver.controller;

import com.rentit.rentitserver.payload.RoommatePostRequest;
import com.rentit.rentitserver.service.RoommatePostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class RoommatePostController {

    private final RoommatePostService roommatePostService;

    @PostMapping("/postroommate")
    public ResponseEntity<?> createRoommatePost(@RequestBody RoommatePostRequest roommatePostRequest){
        return roommatePostService.createRoommatePost(roommatePostRequest);
    }

}
