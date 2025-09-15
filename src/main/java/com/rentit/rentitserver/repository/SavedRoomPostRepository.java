package com.rentit.rentitserver.repository;

import com.rentit.rentitserver.entity.SavedRoomPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedRoomPostRepository extends JpaRepository<SavedRoomPostEntity,Long> {

}
