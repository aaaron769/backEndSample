package com.one.mpp.Services;

import com.one.mpp.Entity.FollowingEntity;
import com.one.mpp.Entity.UserEntity;
import com.one.mpp.Repository.FollowingRepository;
import com.one.mpp.Repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FollowingServicesTest {

    FollowingEntity followingEntity;

    @InjectMocks
    private FollowingServices followingServices;
    @Mock
    private FollowingRepository followingRepositoryMock;
    private UserRepository userRepositoryMock;

    @Test void postFollowing_Success() {
//        FollowingEntity user1 =  new FollowingEntity();
//        user1.setId(3);
//        UserEntity user = userRepositoryMock.findById(3).get();//
//        //user1.setUser(user);//
//        when(followingRepositoryMock.findById(3)).thenReturn(Optional.of(user1));
//
//        FollowingEntity user2 =  new FollowingEntity();
//        user2.setId(2);
//        when(followingRepositoryMock.findById(2)).thenReturn(Optional.of(user2));//
        //user1.setRelatedUser(user.getFollowings().get(2).getRelatedUser());//

        //user1.setRelatedUser(userRepositoryMock.findAllById(2).get());
        //FollowingEntity followingEntity = new FollowingEntity();
        //UserEntity user = userRepository.findById(id).get();
        //followingEntity.setUser(user);
        //followingEntity.setRelatedUser(userRepository.findById(follower_id).get());
        //
        assert (followingServices.postFollower(2,3) != null);
//        assertEquals(followingServices.postFollower(2,3),null);//user1.getUser(),user1.getRelatedUser());
        //assertEquals(2,user1.getRelatedUser());

    }

}

