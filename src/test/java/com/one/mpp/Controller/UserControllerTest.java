package com.one.mpp.Controller;

import com.one.mpp.Constant.MessageConstant;
import com.one.mpp.Entity.UserEntity;
import com.one.mpp.Request.LoginRequest;
import com.one.mpp.Request.UserRequest;
import com.one.mpp.Response.LoginResponse;
import com.one.mpp.Response.UserResponse;
import com.one.mpp.Services.UserServices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    private UserRequest userRequest;
    private LoginRequest loginRequest;

    @InjectMocks
    UserController userController;
    @Mock
    UserServices userServicesMock;

    @Before
    public void setUp() {
        buildUserEntity();
    }

    private void buildUserEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1);
        userEntity.setEmail("abc@gmail.com");
        userEntity.setPassword("123456");
        userEntity.setFirstName("John");
        userEntity.setLastName("Harry");
        userEntity.setImageId("");

        userRequest = new UserRequest();
        userRequest.setUserEntity(userEntity);

        loginRequest = new LoginRequest();
        loginRequest.setUser(userEntity);
    }

    @Test
    public void login_Success() {
        when(userServicesMock.loginResponse(any())).thenReturn(new LoginResponse(true, MessageConstant.LOGIN_SUCCESS.replaceAll("@@user@@", loginRequest.getUser().getEmail())));
        LoginResponse loginResponse = userController.login(loginRequest);
        assertEquals(true, loginResponse.getSuccess());
    }

    @Test
    public void login_Fail() {
        when(userServicesMock.loginResponse(any())).thenReturn(new LoginResponse(MessageConstant.EMAIL_OR_PASSWORD_IS_INVALID));
        LoginResponse loginResponse = userController.login(loginRequest);
        assertEquals(false, loginResponse.getSuccess());
    }

    @Test
    public void createUser_Success() {
        when(userServicesMock.validateCreateUser(any())).thenReturn(null);
        when(userServicesMock.createUser(any())).thenReturn(userRequest.getUserEntity());
        UserResponse userResponse = userController.createUser(userRequest);
        assertEquals(true, userResponse.getSuccess());
    }

    @Test
    public void createUser_Fail() {
        String exception = String.format(MessageConstant.DUPLICATE_EXCEPTION_MESSAGE, "User " + userRequest.getUserEntity().getEmail());
        when(userServicesMock.validateCreateUser(any())).thenReturn(exception);
        UserResponse userResponse = userController.createUser(userRequest);
        assertEquals(exception, userResponse.getExceptionMessage());
    }
}
