package com.one.mpp.Services;

import com.one.mpp.Constant.MessageConstant;
import com.one.mpp.Entity.FollowingEntity;
import com.one.mpp.Entity.UserEntity;
import com.one.mpp.Repository.UserRepository;
import com.one.mpp.Request.LoginRequest;
import com.one.mpp.Response.LoginResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    private Logger logger = LogManager.getLogger(UserServices.class);

    @Autowired
    protected UserRepository usersRepository;

    // View profile
    public UserEntity viewProfile(String email) {
        return usersRepository.findByEmailEquals(email);
    }

    // Login by email
    public LoginResponse loginResponse(LoginRequest loginRequest) {
        logger.info("Validate email [{}] login", loginRequest.getUser().getEmail());
        if (StringUtils.isEmpty(loginRequest.getUser().getEmail())) {
            return new LoginResponse(MessageConstant.EMAIL_OR_PASSWORD_IS_BLANK);
        }
        if (StringUtils.isEmpty(loginRequest.getUser().getPassword())) {
            return new LoginResponse(MessageConstant.EMAIL_OR_PASSWORD_IS_BLANK);
        }
        UserEntity userEntity = usersRepository.findByEmailEquals(loginRequest.getUser().getEmail());
        if (userEntity == null) {
            return new LoginResponse(MessageConstant.EMAIL_OR_PASSWORD_IS_INVALID);
        }
        if (!loginRequest.getUser().getPassword().equals(userEntity.getPassword())) {
            return new LoginResponse(MessageConstant.EMAIL_OR_PASSWORD_IS_INVALID);
        }
        logger.info("Email [{}] login successfully", loginRequest.getUser().getEmail());
        return new LoginResponse(true, MessageConstant.LOGIN_SUCCESS.replaceAll("@@user@@", loginRequest.getUser().getEmail()));
    }

    // Sign up - Create new user
    public UserEntity createUser(UserEntity userEntity) {
        logger.info("Create new user with email [{}]", userEntity.getEmail());
        if (!StringUtils.isEmpty(userEntity.getEmail())) {
            userEntity.setPassword(userEntity.getPassword());
            userEntity.setFirstName(userEntity.getFirstName());
            userEntity.setLastName(userEntity.getLastName());
            userEntity.setImageId(userEntity.getImageId());
            return usersRepository.save(userEntity);
        }
        return null;
    }

    public String validateCreateUser(UserEntity userEntity) {
        logger.info("Validate new email [{}]", userEntity.getEmail());
        if (userEntity.getEmail() == null) {
            return MessageConstant.EMAIL_OR_PASSWORD_IS_BLANK;
        }
        if (userEntity.getPassword() == null) {
            return MessageConstant.EMAIL_OR_PASSWORD_IS_BLANK;
        }
        if (usersRepository.countByEmail(userEntity.getEmail()) > 0) {
            return String.format(MessageConstant.DUPLICATE_EXCEPTION_MESSAGE, "User " + userEntity.getEmail());
        }
        return null;
    }

    //get all users - Mauro
    public List<UserEntity> getFullUserList() { //getAllUsers() {
        List<UserEntity> userEntityList = usersRepository.findAll();
        return userEntityList;
    }

    //add following
    public UserEntity addFollowing(FollowingEntity followingEntity) {
        UserEntity user = followingEntity.getUser();
        user.getFollowings().add(followingEntity);
        usersRepository.save(user);
        return user;
    }
}
