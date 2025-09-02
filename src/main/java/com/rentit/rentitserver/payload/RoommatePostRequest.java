package com.rentit.rentitserver.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoommatePostRequest {
    private Long userId;
    private String description;
    private Double rentAmount;
    private String roomType;
    private String address;
    private String city;
    private String pincode;
    private String preferredGender;
    private Integer availableSeats;
}
