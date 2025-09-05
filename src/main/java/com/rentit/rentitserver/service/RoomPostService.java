package com.rentit.rentitserver.service;

import com.rentit.rentitserver.dto.RoomPostDTO;
import com.rentit.rentitserver.entity.RoomPostEntity;
import com.rentit.rentitserver.entity.UserEntity;
import com.rentit.rentitserver.payload.RoomPostRequest;
import com.rentit.rentitserver.repository.RoomPostRepository;
import com.rentit.rentitserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomPostService {

    private final RoomPostRepository roomPostRepository;
    private final UserRepository userRepository;

    public ResponseEntity<?> createRoomPost(RoomPostRequest roomPostRequest) {
        try {
            UserEntity userEntity = userRepository.findById(roomPostRequest.getUserId())
                    .orElse(null);

            if (userEntity == null)
                return ResponseEntity.badRequest().body("User not found");

            RoomPostEntity roomPostEntity = new RoomPostEntity();
            roomPostEntity.setDescription(roomPostRequest.getDescription());
            roomPostEntity.setRoomType(roomPostRequest.getRoomType());
            roomPostEntity.setRentAmount(roomPostRequest.getRentAmount());
            roomPostEntity.setAddress(roomPostRequest.getAddress());
            roomPostEntity.setCity(roomPostRequest.getCity());
            roomPostEntity.setPincode(roomPostRequest.getPincode());
            roomPostEntity.setPostedAt(LocalDateTime.now());
            roomPostEntity.setPostedBy(userEntity);

            roomPostRepository.save(roomPostEntity);


            return ResponseEntity.ok().body("Room Post Created Successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
        }
    }

    public List<RoomPostDTO> getAllRoomPosts() {
        return roomPostRepository.findAll().stream()
                .map(post -> new RoomPostDTO(
                        post.getPostId(),
                        post.getDescription(),
                        post.getRoomType(),
                        post.getRentAmount(),
                        post.getAddress(),
                        post.getCity(),
                        post.getPincode(),
                        post.getPostedBy().getUserId(),
                        post.getPostedAt()
                ))
                .toList();
    }
}
