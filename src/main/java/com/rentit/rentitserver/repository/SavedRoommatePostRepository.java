package com.rentit.rentitserver.repository;

import com.rentit.rentitserver.entity.SavedRoommatePostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SavedRoommatePostRepository extends JpaRepository<SavedRoommatePostEntity,Long> {

    @Query("SELECT s FROM SavedRoommatePostEntity s WHERE s.savedBy.userId = :userId")
    List<SavedRoommatePostEntity> findByUserId(@Param("userId") Long userId);

}
