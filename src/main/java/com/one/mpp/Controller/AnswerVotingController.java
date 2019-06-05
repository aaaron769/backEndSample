package com.one.mpp.Controller;


import com.one.mpp.Entity.AnswerVoting;
import com.one.mpp.Services.AnswerVotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
// the rest controller
// The Rest controller

@RestController
@CrossOrigin

public class AnswerVotingController {

    @Autowired
    private AnswerVotingService service;

    //upvoteCount
    @RequestMapping(value = "answers/{id}/upvote", method = RequestMethod.GET)
    public @ResponseBody
    Integer getUpVotes(@PathVariable Integer id) {
        return this.service.getUpVotes(id);
    }

    //downvoteCount
    @RequestMapping(value = "answers/{id}/downvote", method = RequestMethod.GET)
    public @ResponseBody
    Integer getDownVotes(@PathVariable Integer id) {
        return this.service.getDownVotes(id);
    }

    //downVote
    @RequestMapping(value = "answers/{id}/downvote", method = RequestMethod.POST)
    public @ResponseBody
    Integer postDownVotes(@PathVariable Integer id, @RequestBody AnswerVoting voting) {
        return this.service.postDownVote(id, voting);
    }

    //upVote
    @RequestMapping(value = "answers/{id}/upvote", method = RequestMethod.POST)
    public @ResponseBody
    Integer postUpVotes(@PathVariable Integer id, @RequestBody AnswerVoting voting) {
        return this.service.postUpVote(id, voting);
    }


}
