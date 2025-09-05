package com.rentit.rentitserver.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomPostDTO {
    private Long postId;
    private String description;
    private String roomType;
    private Double rentAmount;
    private String address;
    private String city;
    private String pincode;
    private Long postedBy;
    private LocalDateTime postedAt;
}
