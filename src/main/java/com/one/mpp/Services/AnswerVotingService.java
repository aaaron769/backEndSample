package com.one.mpp.Services;


import com.one.mpp.Entity.AnswerVoting;
import com.one.mpp.Repository.AnswerVotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerVotingService {
    @Autowired
    AnswerVotingRepository repository;

    public Integer getUpVotes(Integer id) {
        try {
            return this.repository.countByAnswerIdAndAction(id, 1).orElse(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public Integer getDownVotes(Integer id) {
        try {
            return this.repository.countByAnswerIdAndAction(id, 0).orElse(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    protected AnswerVoting getVote(Integer answerId, Integer userId) {
        try {
            return this.repository.findByAnswerIdAndUserId(answerId, userId).orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    //downvote
    public Integer postDownVote(Integer id, AnswerVoting voting) {

        AnswerVoting vote = this.getVote(id, voting.getUserId());

        if (vote == null) {
            voting.setAnswerId(id);
            voting.setAction(0);
            this.repository.save(voting);
            return this.getDownVotes(id);
        }

        if (vote.getAction() == 1) {
            vote.setAction(0);
            this.repository.save(vote);
        }
        return this.getDownVotes(id);
    }

    //upvote
    public Integer postUpVote(Integer id, AnswerVoting voting) {

        AnswerVoting vote = this.getVote(id, voting.getUserId());

        if (vote == null) {
            voting.setAnswerId(id);
            voting.setAction(1);
            this.repository.save(voting);
            return this.getUpVotes(id);
        }

        if (vote.getAction() == 0) {
            vote.setAction(1);
            this.repository.save(vote);
        }

        return this.getUpVotes(id);
    }
}
