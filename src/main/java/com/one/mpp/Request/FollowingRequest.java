package com.one.mpp.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.one.mpp.Entity.FollowingEntity;

public class FollowingRequest {

    private int id;
    private int follower_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(int follower_id) {
        this.follower_id = follower_id;
    }

    //    @JsonProperty("followingEntity")
//    private FollowingEntity followingEntity;
//
//    public FollowingEntity getFollowingEntity() {
//        return followingEntity;
//    }
//
//    public void setFollowingEntity(FollowingEntity followingEntity) {
//        this.followingEntity = followingEntity;
//    }
}
