package com.one.mpp.Services;

import com.one.mpp.Entity.FollowingEntity;
import com.one.mpp.Entity.UserEntity;
import com.one.mpp.Repository.FollowingRepository;
import com.one.mpp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowingServices {
    @Autowired
    protected FollowingRepository followingRepository;
    @Autowired
    private UserRepository userRepository;

    public List<FollowingEntity> findAllFollowing() {
        return followingRepository.findAll();
    }

    public FollowingEntity postFollower(Integer id, Integer follower_id) {
        FollowingEntity followingEntity = new FollowingEntity();
        UserEntity user = userRepository.findById(id).get();
        followingEntity.setUser(user);
        followingEntity.setRelatedUser(userRepository.findById(follower_id).get());
        this.followingRepository.save(followingEntity);
        return followingEntity;
    }


    //create following
    public FollowingEntity createFollowing(FollowingEntity fl) {
        return followingRepository.save(fl);
    }

    //Get Following Count By Integer
    public Integer getFollowingCountByInteger(String userName) {
        return 7;
    }


    //Get following count
    public List<FollowingEntity> getFollowingCount(String userName) {
        List<FollowingEntity> allFollowingList = followingRepository.findAll();
        return new ArrayList<>();
    }

    //Get full following list
    public List<FollowingEntity> getFullFollowingList() {
        return followingRepository.findAll();
    }

    public FollowingEntity getFollowersByName(String userEntity, String targetUserName) {
        return new FollowingEntity();
    }

    public List<UserEntity> getListFollowers(List<UserEntity> userEntityList, List<FollowingEntity> followingList, String targetUserName) {
        return null;
    }

}
