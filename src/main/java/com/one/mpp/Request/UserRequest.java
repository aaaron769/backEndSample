package com.one.mpp.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.one.mpp.Entity.UserEntity;

public class UserRequest {

    @JsonProperty("userEntity")
    private UserEntity userEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
