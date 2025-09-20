package com.rentit.rentitserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoommatePostDTO {
    private Long postId;
    private String description;
    private Double rentAmount;
    private String roomType;
    private String address;
    private String city;
    private String pincode;
    private String preferredGender;
    private Integer availableSeats;
    private LocalDateTime postedAt;
    private Long postedBy;
}
