package com.rentit.rentitserver.service;

import com.rentit.rentitserver.entity.SavedPostEntity;
import com.rentit.rentitserver.entity.UserEntity;
import com.rentit.rentitserver.payload.SavePostRequest;
import com.rentit.rentitserver.repository.SavePostRepository;
import com.rentit.rentitserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SavePostService {

    private final SavePostRepository savePostRepository;
    private final UserRepository userRepository;

    public ResponseEntity<?> savePost(SavePostRequest savePostRequest) {
        try {
            UserEntity userEntity = userRepository.findById(savePostRequest.getUserId()).orElse(null);
            if(userEntity == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");

            SavedPostEntity savedPostEntity = new SavedPostEntity();
            savedPostEntity.setPostType(savePostRequest.getPostType());
            savedPostEntity.setSavedBy(userEntity);
            savedPostEntity.setPostId(savePostRequest.getPostId());
            savedPostEntity.setPostType(savePostRequest.getPostType());
            savedPostEntity.setSavedAt(LocalDateTime.now());

            savePostRepository.save(savedPostEntity);

            return ResponseEntity.status(HttpStatus.CREATED).body("Post saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!");
        }
    }

    public List<SavedPostEntity> getAllSavedPost(Long userId) {
        return savePostRepository.findBySavedBy_UserId(userId);
    }
}
