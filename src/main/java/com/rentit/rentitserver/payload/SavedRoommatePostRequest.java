package com.rentit.rentitserver.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavedRoommatePostRequest {
    private Long userId;
    private Long roommatePostId;
}
