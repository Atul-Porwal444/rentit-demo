package com.rentit.rentitserver.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomPostRequest {
    private Long userId;
    private String description;
    private String roomType;
    private Double rentAmount;
    private String address;
    private String city;
    private String pincode;
}
