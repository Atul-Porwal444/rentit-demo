package com.rentit.rentitserver.controller;

import com.rentit.rentitserver.payload.SavedRoomPostRequest;
import com.rentit.rentitserver.service.SavedRoomPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class SavedRoomPostController {
    private final SavedRoomPostService savedRoomPostService;

    @PostMapping("/saveroompost")
    public ResponseEntity<?> saveRoomPost(@RequestBody SavedRoomPostRequest savedRoomPostRequest) {
        return savedRoomPostService.saveRoomPost(savedRoomPostRequest);
    }


}
