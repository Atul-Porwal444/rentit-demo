package com.rentit.rentitserver.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private  Long userId;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "postedBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoomPostEntity> posts = new ArrayList<>();

    @OneToMany(mappedBy = "postedBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RoommatePostEntity> roommates = new ArrayList<>();

    @OneToMany(mappedBy = "savedBy" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SavedRoomPostEntity> savedRoomPosts = new ArrayList<>();

    @OneToMany(mappedBy = "savedBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SavedRoommatePostEntity> savedRoommatesPosts = new ArrayList<>();
}
