package com.rentit.rentitserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "saved_roommate_posts")
public class SavedRoommatePostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saveId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity savedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roommate_post_id")
    private RoommatePostEntity roommatePost;
}
