package com.rentit.rentitserver.repository;

import com.rentit.rentitserver.entity.RoomPostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomPostRepository extends JpaRepository<RoomPostEntity,Long> {



}
