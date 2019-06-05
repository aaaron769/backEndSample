package com.one.mpp.Controller;

import com.one.mpp.Entity.FollowingEntity;
import com.one.mpp.Request.FollowingRequest;
import com.one.mpp.Services.FollowingServices;
import com.one.mpp.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class FollowingController {

    @Autowired
    private FollowingServices followingService;

    @Autowired
    private UserServices userService;

    @GetMapping("/getFollowings")
    public List<FollowingEntity> getAll() {
        return followingService.findAllFollowing();
    }

    @RequestMapping(value = "/addFollowing", method = RequestMethod.POST)
    public FollowingEntity addFollowing(@RequestBody FollowingRequest followingRequest) {
        return followingService.postFollower(followingRequest.getId(), followingRequest.getFollower_id());
    }

}

