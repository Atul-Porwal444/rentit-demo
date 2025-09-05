package com.rentit.rentitserver.repository;

import com.rentit.rentitserver.entity.SavedPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavePostRepository extends JpaRepository<SavedPostEntity, Long> {

}
