package com.one.mpp.Services;

import com.one.mpp.Entity.UserEntity;
import com.one.mpp.Repository.UserRepository;
import com.one.mpp.Request.LoginRequest;
import com.one.mpp.Response.LoginResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServicesTest {

    UserEntity userEntity;
    LoginRequest loginRequest;

    @InjectMocks
    private UserServices userServices;
    @Mock
    private UserRepository userRepositoryMock;

    @Before
    public void setUp() {
        buildUserEntity();
    }

    private void buildUserEntity() {
        userEntity = new UserEntity();
        userEntity.setId(1);
        userEntity.setEmail("abc@gmail.com");
        userEntity.setPassword("123456");
        userEntity.setFirstName("John");
        userEntity.setLastName("Harry");
        userEntity.setImageId("");


        loginRequest = new LoginRequest();
        loginRequest.setUser(userEntity);
    }

    @Test
    public void loginResponse_Success() {
        UserEntity tempEntity = new UserEntity();
        tempEntity.setEmail(userEntity.getEmail());
        tempEntity.setPassword(userEntity.getPassword());
        when(userRepositoryMock.findByEmailEquals(any())).thenReturn(tempEntity);

        LoginResponse result = userServices.loginResponse(loginRequest);
        assertEquals(result.getSuccess(), true);
    }

    @Test
    public void loginResponse_Fail() {
        when(userRepositoryMock.findByEmailEquals(any())).thenReturn(null);
        LoginResponse loginResponse = userServices.loginResponse(loginRequest);
        assertEquals(loginResponse.getSuccess(), false);
    }

    @Test
    public void createUser_Success() {
        when(userRepositoryMock.save(any())).thenReturn(userEntity);
        UserEntity data = userServices.createUser(userEntity);
        assertEquals(userEntity.getId(), data.getId());
    }

    @Test
    public void postFollowing_Success() {
        UserEntity user1 = new UserEntity();
        user1.setId(3);
        when(userRepositoryMock.findById(3)).thenReturn(Optional.of(user1));
        UserEntity user2 = new UserEntity();
        user2.setId(2);
        when(userRepositoryMock.findById(2)).thenReturn(Optional.of(user2));
    }

    @Test
    public void createUser_Fail() {
        String prevEmail = userEntity.getEmail();
        userEntity.setEmail("");
        UserEntity data = userServices.createUser(userEntity);
        userEntity.setEmail(prevEmail);
        assertNull(data);
    }

    @Test
    public void validateCreateUser_Success() {
        when(userRepositoryMock.countByEmail(any())).thenReturn(0);
        String data = userServices.validateCreateUser(userEntity);
        assertNull(data);
    }

    @Test
    public void validateCreateUser_Fail() {
        when(userRepositoryMock.countByEmail(any())).thenReturn(1);
        String data = userServices.validateCreateUser(userEntity);
        assertNotNull(data);
    }
}
