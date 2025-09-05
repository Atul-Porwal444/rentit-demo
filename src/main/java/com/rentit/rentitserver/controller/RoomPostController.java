package com.rentit.rentitserver.controller;

import com.rentit.rentitserver.payload.RoomPostRequest;
import com.rentit.rentitserver.service.RoomPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class RoomPostController {

    private final RoomPostService roomPostService;

    @PostMapping("/postroom")
    public ResponseEntity<?> createRoomPost(@RequestBody RoomPostRequest roomPostRequest) {
        return roomPostService.createRoomPost(roomPostRequest);
    }

    @GetMapping("/getroompost")
    public ResponseEntity<?> getAllRoomPost(){
        return ResponseEntity.ok(roomPostService.getAllRoomPosts());
    }
}
