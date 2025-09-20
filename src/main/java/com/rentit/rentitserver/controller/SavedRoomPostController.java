package com.rentit.rentitserver.controller;

import com.rentit.rentitserver.payload.SavedRoomPostRequest;
import com.rentit.rentitserver.service.SavedRoomPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class SavedRoomPostController {
    private final SavedRoomPostService savedRoomPostService;

    @PostMapping("/saveroompost")
    public ResponseEntity<?> saveRoomPost(@RequestBody SavedRoomPostRequest savedRoomPostRequest) {
        return savedRoomPostService.saveRoomPost(savedRoomPostRequest);
    }

    @GetMapping("/savedroomposts")
    public ResponseEntity<?> getAllSavedRoomPosts(@RequestParam Long userId) {
        return savedRoomPostService.getAllSavedRoomPosts(userId);
    }

    @DeleteMapping("/unsaveroompost")
    public ResponseEntity<?> deleteSavedRoomPost(@RequestParam Long saveId) {
        return savedRoomPostService.unsaveRoomPost(saveId);
    }


}
