package com.rentit.rentitserver.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SavePostRequest {
    private Long userId;
    private Long postId;
    private String postType;
}
