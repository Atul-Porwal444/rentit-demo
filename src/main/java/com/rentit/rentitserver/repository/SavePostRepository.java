package com.rentit.rentitserver.repository;

import com.rentit.rentitserver.entity.SavedPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavePostRepository extends JpaRepository<SavedPostEntity, Long> {
    List<SavedPostEntity> findBySavedBy_UserId(Long userId);
}
