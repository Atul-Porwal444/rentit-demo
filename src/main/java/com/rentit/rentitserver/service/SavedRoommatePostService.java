package com.rentit.rentitserver.service;

import com.rentit.rentitserver.dto.SavedRoommatePostDTO;
import com.rentit.rentitserver.entity.RoommatePostEntity;
import com.rentit.rentitserver.entity.SavedRoommatePostEntity;
import com.rentit.rentitserver.entity.UserEntity;
import com.rentit.rentitserver.payload.SavedRoommatePostRequest;
import com.rentit.rentitserver.repository.RoommatePostRepository;
import com.rentit.rentitserver.repository.SavedRoommatePostRepository;
import com.rentit.rentitserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SavedRoommatePostService {
    private final UserRepository userRepository;
    private final RoommatePostRepository roommatePostRepository;
    private final SavedRoommatePostRepository savedRoommatePostRepository;

    public ResponseEntity<?> saveRoommatePost(SavedRoommatePostRequest savedRoommatePostRequest) {
        try {

            UserEntity userEntity = userRepository.findById(savedRoommatePostRequest.getUserId()).orElse(null);
            if (userEntity == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found!");
            }

            RoommatePostEntity roommatePostEntity = roommatePostRepository.findById(savedRoommatePostRequest.getRoommatePostId()).orElse(null);
            if (roommatePostEntity == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Roommate post not found!");
            }

            SavedRoommatePostEntity savedRoommatePostEntity = new SavedRoommatePostEntity();
            savedRoommatePostEntity.setSavedBy(userEntity);
            savedRoommatePostEntity.setRoommatePost(roommatePostEntity);

            savedRoommatePostRepository.save(savedRoommatePostEntity);

            return ResponseEntity.ok("Roommate post saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!!");
        }
    }

    public ResponseEntity<?> getAllSavedRoommatePosts(Long userId) {
        try {

            return ResponseEntity.ok(savedRoommatePostRepository.findByUserId(userId).stream()
                    .map(savedPost -> new SavedRoommatePostDTO(
                            savedPost.getSaveId(),
                            savedPost.getRoommatePost().getPostId(),
                            savedPost.getRoommatePost().getDescription(),
                            savedPost.getRoommatePost().getRoomType(),
                            savedPost.getRoommatePost().getRentAmount(),
                            savedPost.getRoommatePost().getAddress(),
                            savedPost.getRoommatePost().getCity(),
                            savedPost.getRoommatePost().getPincode(),
                            savedPost.getRoommatePost().getPreferredGender(),
                            savedPost.getRoommatePost().getAvailableSeats(),
                            savedPost.getRoommatePost().getPostedBy().getUserId()
                    ))
                    .toList());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!!");
        }
    }

    public ResponseEntity<?> unsaveRoommatePost(Long saveId) {
        try {
            if(savedRoommatePostRepository.existsById(saveId)) {
                savedRoommatePostRepository.deleteById(saveId);
                return ResponseEntity.ok("Roommate post unsaved successfully!");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Roommate post not found!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!!");
        }
    }
}
