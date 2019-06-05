//package com.one.mpp.Controller;
//
//import com.one.mpp.Constant.MessageConstant;
//import com.one.mpp.Entity.UserEntity;
//import com.one.mpp.Request.LoginRequest;
//import com.one.mpp.Request.UserRequest;
//import com.one.mpp.Response.LoginResponse;
//import com.one.mpp.Services.UserServices;
//
//import com.one.mpp.Entity.FollowingEntity;
//import com.one.mpp.Request.FollowingRequest;
//import com.one.mpp.Response.FollowingResponse;
//import com.one.mpp.Services.FollowingServices;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class FollowingControllerTest {
//
//    private UserRequest userRequest;
//    private FollowingRequest followingRequest;
//
//    @InjectMocks
//    FollowingController followingController;
//    @Mock
//    FollowingServices followingServicesMock;
//
//    @Test
//    public void addFollowing_Success() {
////        when(followingServicesMock.validateAddFollowing(any())).thenReturn(null);
////        when(followingServicesMock.addFollowing(any())).thenReturn(followingRequest.getFollowingEntity());
////        FollowingResponse followingResponse = followingController.addFollowing(followingRequest);
////        assertEquals(true, followingResponse.getSuccess());
//    }
//
//    @Test
//    public void addFollowing_Fail() {
////        String exception = String.format(MessageConstant.DUPLICATE_EXCEPTION_MESSAGE, "User " + userRequest.getUserEntity().getEmail());
////        when(userServicesMock.validateCreateUser(any())).thenReturn(exception);
////        UserResponse userResponse = userController.createUser(userRequest);
////        assertEquals(exception, userResponse.getExceptionMessage());
//    }
//}
