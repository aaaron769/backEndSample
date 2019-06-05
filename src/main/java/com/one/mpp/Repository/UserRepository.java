package com.one.mpp.Repository;

import com.one.mpp.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByEmailEquals(String email);
    Integer countByEmail(String email);

    List<UserEntity> findAll(); //Mauro

}
