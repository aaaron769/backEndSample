package com.one.mpp.Controller;

import com.one.mpp.Constant.MessageConstant;
import com.one.mpp.Entity.UserEntity;
import com.one.mpp.Request.LoginRequest;
import com.one.mpp.Request.UserRequest;
import com.one.mpp.Response.LoginResponse;
import com.one.mpp.Response.UserResponse;
import com.one.mpp.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserServices userServices;

    // Login
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody
    LoginResponse login(@RequestBody LoginRequest loginRequest) {
        try {
            return userServices.loginResponse(loginRequest);
        } catch (Exception e) {
            return new LoginResponse(e.getMessage());
        }
    }

    // View profile
    @RequestMapping(value = "profile/{email}", method = RequestMethod.GET)
    public @ResponseBody
    UserEntity viewProfile(@PathVariable("email") String email) {
        return userServices.viewProfile(email);
    }

    // Sign up - Create new user
    @RequestMapping(value = "newUser", method = RequestMethod.POST)
    public @ResponseBody
    UserResponse createUser(@RequestBody UserRequest userRequest) {
        try {
            String eMessage = userServices.validateCreateUser(userRequest.getUserEntity());
            if (eMessage != null) {
                return new UserResponse<>(false, eMessage);
            } else {
                UserEntity userEntity = userServices.createUser(userRequest.getUserEntity());
                if (userEntity.getId() != null) {
                    return new UserResponse<>(true, null, MessageConstant.CREATE_USER_SUCCESS.replaceAll("@@user@@", userEntity.getEmail()));
                } else {
                    return new UserResponse<>(false, MessageConstant.CREATE_USER_FAIL.replaceAll("@@user@@", userEntity.getEmail()));
                }
            }
        } catch (Exception e) {
            return new UserResponse<>(false, e.getMessage());
        }
    }

    //Get All Users - Mauro
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public @ResponseBody
    List<UserEntity> getUsers() {
        return this.userServices.getFullUserList();
    }

    @RequestMapping(value = "counting", method = RequestMethod.GET)
    public @ResponseBody
    List<Integer> getUsers1() {
        List<Integer> result= new ArrayList<>();
        List<UserEntity> fullUserList = this.userServices.getFullUserList();
        //fullUserList.forEach(u -> result.add(u.getFollowingCount()));
        for (UserEntity u : fullUserList) {
            result.add(u.getFollowingCount());
        }
        return result;
    }
}
