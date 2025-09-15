package com.rentit.rentitserver.service;

import com.rentit.rentitserver.entity.RoomPostEntity;
import com.rentit.rentitserver.entity.SavedRoomPostEntity;
import com.rentit.rentitserver.entity.UserEntity;
import com.rentit.rentitserver.payload.SavedRoomPostRequest;
import com.rentit.rentitserver.repository.RoomPostRepository;
import com.rentit.rentitserver.repository.SavedRoomPostRepository;
import com.rentit.rentitserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SavedRoomPostService {
    private final UserRepository userRepository;
    private final RoomPostRepository roomPostRepository;
    private final SavedRoomPostRepository savedRoomPostRepository;

    public ResponseEntity<?> saveRoomPost(SavedRoomPostRequest savedRoomPostRequest) {
        try {
            UserEntity userEntity = userRepository.findById(savedRoomPostRequest.getUserId()).orElse(null);
            if(userEntity == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
            }

            RoomPostEntity roomPostEntity = roomPostRepository.findById(savedRoomPostRequest.getRoomPostId()).orElse(null);
            if(roomPostEntity == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room post not found");
            }

            SavedRoomPostEntity savedRoomPostEntity = new SavedRoomPostEntity();

            savedRoomPostEntity.setSavedBy(userEntity);
            savedRoomPostEntity.setRoomPost(roomPostEntity);

            savedRoomPostRepository.save(savedRoomPostEntity);

            return ResponseEntity.ok("Post saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!");
        }
    }
}
