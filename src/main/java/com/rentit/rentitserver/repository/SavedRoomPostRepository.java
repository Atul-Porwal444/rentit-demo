package com.rentit.rentitserver.repository;

import com.rentit.rentitserver.entity.SavedRoomPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SavedRoomPostRepository extends JpaRepository<SavedRoomPostEntity,Long> {


    @Query("SELECT s FROM SavedRoomPostEntity s WHERE s.savedBy.userId = :userId")
    List<SavedRoomPostEntity> findByUserId(@Param("userId") Long userId);

}
