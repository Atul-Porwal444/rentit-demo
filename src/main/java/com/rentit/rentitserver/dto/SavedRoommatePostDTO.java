package com.rentit.rentitserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavedRoommatePostDTO {
    private Long savedId;
    private Long postId;
    private String description;
    private String roomType;
    private Double rentAmount;
    private String address;
    private String city;
    private String pincode;
    private String preferredGender;
    private Integer availableSeats;
    private Long postedBy;

}
