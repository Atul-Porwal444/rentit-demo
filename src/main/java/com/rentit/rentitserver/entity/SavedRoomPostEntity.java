package com.rentit.rentitserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "saved_room_posts")
public class SavedRoomPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saveId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity savedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_post_id", nullable = false)
    private RoomPostEntity roomPost;

}
