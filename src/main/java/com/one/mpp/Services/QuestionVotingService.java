package com.one.mpp.Services;

import com.one.mpp.Entity.QuestionVoting;
import com.one.mpp.Repository.QuestionVotingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionVotingService {

    @Autowired
    QuestionVotingRepository repository;

    public Integer getUpVotes(Integer id) {
        try {
            return this.repository.countByQuestionIdAndAction(id, 1).orElse(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }


    public Integer getDownVotes(Integer id) {
        try {
            return this.repository.countByQuestionIdAndAction(id, 0).orElse(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }

    }

    //UpVote
    public Integer postUpVote(Integer id, QuestionVoting voting) {

        QuestionVoting vote = this.getVote(id, voting.getUserId());

        if (vote == null) {
            voting.setQuestionId(id);
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

    protected QuestionVoting getVote(Integer questionId, Integer userId) {
        try {
            return this.repository.findByQuestionIdAndUserId(questionId, userId).orElse(null);
        } catch (Exception e) {
            return null;
        }

    }


    //DownVOte
    public Integer postDownVote(Integer id, QuestionVoting voting) {

        QuestionVoting vote = this.getVote(id, voting.getUserId());

        if (vote == null) {
            voting.setQuestionId(id);
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
}
