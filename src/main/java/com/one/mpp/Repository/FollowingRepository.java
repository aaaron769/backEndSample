package com.one.mpp.Repository;

import com.one.mpp.Entity.FollowingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowingRepository extends JpaRepository<FollowingEntity, Integer> {

    List<FollowingEntity> findAll();
//    List<FollowingEntity> findAllByUserNameEquals(String userName);
//    FollowingEntity findByUserId(Integer followerId, Integer userId);
//    FollowingEntity findByUserNameEqualsAndAndRelateUserNameEquals(String userName, String relateUserName);
//    List<FollowingEntity> findAllByEmail();
//    FollowingEntity findByRelateUserNameEqualsAndAndUserNameEquals(String relatedUserName, String UserName);
//    List<FollowingEntity> findFollowingEntityByRelatedEmail(String email);
}
