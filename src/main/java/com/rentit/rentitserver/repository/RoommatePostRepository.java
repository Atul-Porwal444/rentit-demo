package com.rentit.rentitserver.repository;

import com.rentit.rentitserver.entity.RoommatePostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoommatePostRepository extends JpaRepository<RoommatePostEntity,Long> {

}
