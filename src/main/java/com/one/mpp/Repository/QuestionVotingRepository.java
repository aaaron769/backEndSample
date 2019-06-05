package com.one.mpp.Repository;

import com.one.mpp.Entity.QuestionVoting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionVotingRepository extends JpaRepository<QuestionVoting, Integer> {
    Optional<Integer> countByQuestionIdAndAction(Integer id, Integer action);

    Optional<QuestionVoting> findByQuestionIdAndUserId(Integer id, Integer userId);
}
