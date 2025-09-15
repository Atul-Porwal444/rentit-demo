package com.rentit.rentitserver.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavedRoomPostRequest {
    private Long userId;
    private Long roomPostId;
}
