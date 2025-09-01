package com.rentit.rentitserver.repository;

import com.rentit.rentitserver.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Boolean existsByEmail(String email);

    UserEntity findByEmail(String email);

}
