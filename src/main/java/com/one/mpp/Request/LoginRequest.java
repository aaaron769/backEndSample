package com.one.mpp.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.one.mpp.Entity.UserEntity;

public class LoginRequest {

    @JsonProperty("userEntity")
    private UserEntity userEntity;

    public UserEntity getUser() {
        return userEntity;
    }

    public void setUser(UserEntity user) {
        this.userEntity = user;
    }
}
