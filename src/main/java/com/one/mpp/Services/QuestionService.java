package com.one.mpp.Services;

import com.one.mpp.Entity.QuestionEntity;
import com.one.mpp.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired()
    private QuestionRepository repository;

    public List<QuestionEntity> getAllQuestions() {
        return this.repository.findAll();
    }

    public QuestionEntity addQuestion(QuestionEntity question) {
        return this.repository.save(question);
    }

    public QuestionEntity getQuestionById(Integer id) throws Exception {

        QuestionEntity question = this.repository.findById(id).orElse(null);
        if (question == null) {
            throw new Exception("No QuestionEntity Found");
        }
        return question;
    }

    public QuestionEntity updateQuestion(Integer id, QuestionEntity question) throws Exception {
        QuestionEntity question1 = this.getQuestionById(id);
//        if (question1 == null) {
//            throw new Exception("No QuestionEntity Found");
//        }
        if (question.getTitle() != null) {
            question1.setTitle(question.getTitle());
        }
        if (question.getContent() != null) {
            question1.setContent(question.getContent());
        }
        return this.repository.save(question1);
    }

    public QuestionEntity deleteQuestionById(Integer id) throws Exception {
        QuestionEntity question1 = this.getQuestionById(id);
//        if (question1 == null) {
//            throw new Exception("No QuestionEntity Found");
//        }
        this.repository.delete(question1);
        return question1;
    }
}
