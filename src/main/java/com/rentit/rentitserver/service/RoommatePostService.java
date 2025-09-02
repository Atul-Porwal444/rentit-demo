package com.rentit.rentitserver.service;


import com.rentit.rentitserver.entity.RoommatePostEntity;
import com.rentit.rentitserver.entity.UserEntity;
import com.rentit.rentitserver.payload.RoommatePostRequest;
import com.rentit.rentitserver.repository.RoommatePostRepository;
import com.rentit.rentitserver.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RoommatePostService {

    private final RoommatePostRepository roommatePostRepository;
    private final UserRepository userRepository;

    public ResponseEntity<?> createRoommatePost(RoommatePostRequest roommatePostRequest) {
        try {

            UserEntity userEntity = userRepository.findById(roommatePostRequest.getUserId())
                    .orElse(null);

            if (userEntity == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");

            RoommatePostEntity  roommatePostEntity = new RoommatePostEntity();
            roommatePostEntity.setDescription(roommatePostRequest.getDescription());
            roommatePostEntity.setRentAmount(roommatePostRequest.getRentAmount());
            roommatePostEntity.setRoomType(roommatePostRequest.getRoomType());
            roommatePostEntity.setAddress(roommatePostRequest.getAddress());
            roommatePostEntity.setCity(roommatePostRequest.getCity());
            roommatePostEntity.setPincode(roommatePostRequest.getPincode());
            roommatePostEntity.setPreferredGender(roommatePostRequest.getPreferredGender());
            roommatePostEntity.setAvailableSeats(roommatePostRequest.getAvailableSeats());
            roommatePostEntity.setPostedAt(LocalDateTime.now());
            roommatePostEntity.setPostedBy(userEntity);

            roommatePostRepository.save(roommatePostEntity);

            return ResponseEntity.ok().body("RoommatePost created successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong!");
        }
    }

}
