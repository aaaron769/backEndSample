package com.one.mpp.Repository;

import com.one.mpp.Entity.AnswerVoting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerVotingRepository extends JpaRepository<AnswerVoting, Integer> {
    Optional<Integer> countByAnswerIdAndAction(Integer id, Integer action);

    Optional<AnswerVoting> findByAnswerIdAndUserId(Integer id, Integer userId);
}
