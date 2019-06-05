package com.one.mpp.Controller;


import com.one.mpp.Entity.QuestionVoting;
import com.one.mpp.Services.QuestionVotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class QuestionVotingController {

    @Autowired
    private QuestionVotingService service;

    //upVoteCount
    @RequestMapping(value = "questions/{id}/upvote", method = RequestMethod.GET)
    public @ResponseBody
    Integer getUpVotes(@PathVariable Integer id) {
        return this.service.getUpVotes(id);
    }


    //downVoteCount
    @RequestMapping(value = "questions/{id}/downvote", method = RequestMethod.GET)
    public @ResponseBody
    Integer getDownVotes(@PathVariable Integer id) {
        return this.service.getDownVotes(id);
    }


    //upVote

    @RequestMapping(value = "questions/{id}/upvote", method = RequestMethod.POST)
    public @ResponseBody
    Integer postUpVotes(@PathVariable Integer id, @RequestBody QuestionVoting voting) {
        return this.service.postUpVote(id, voting);
    }


    //downVote
    @RequestMapping(value = "questions/{id}/downvote", method = RequestMethod.POST)
    public @ResponseBody
    Integer postDownVotes(@PathVariable Integer id, @RequestBody QuestionVoting voting) {
        return this.service.postDownVote(id, voting);


    }
}
