package com.one.mpp.Services;

import com.one.mpp.Entity.AnswerEntity;
import com.one.mpp.Repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository repository;

    public List<AnswerEntity> getAllAnswers() {
        return this.repository.findAll();
    }

    public AnswerEntity postAnswer(AnswerEntity answer) throws Exception{
        AnswerEntity answerEntity = this.repository.save(answer);
        return this.getAnswerById(answerEntity.getId());
    }

    public AnswerEntity getAnswerById(Integer answer_id) throws Exception {
        AnswerEntity answer = this.repository.findById(answer_id).orElse(null);
        if (answer == null) {
            throw new Exception("No answer Found");
        }
        return answer;
    }

    public AnswerEntity updateAnswerById(Integer answer_id, AnswerEntity answer) throws Exception {
        AnswerEntity oldAnswer = this.getAnswerById(answer_id);

        if (oldAnswer.getContent() != null) {
            oldAnswer.setContent(answer.getContent());
        }
        return this.repository.save(answer);
    }

    public AnswerEntity deleteAnswerById(Integer answer_id) throws Exception {
        AnswerEntity answer = this.getAnswerById(answer_id);

        this.repository.delete(answer);
        return answer;


    }
}
