package com.one.mpp.Controller;

import com.one.mpp.Entity.QuestionEntity;
import com.one.mpp.Services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class QuestionController {

    @Autowired
    private QuestionService service;

    //GetAllQuestions
    @RequestMapping(value = "questions", method = RequestMethod.GET)
    public @ResponseBody
    List<QuestionEntity> getQuestions() {
        return this.service.getAllQuestions();
    }

    //addQuestion
    @RequestMapping(value = "questions", method = RequestMethod.POST)
    public @ResponseBody
    QuestionEntity postQuestions(@RequestBody QuestionEntity question) {
        return this.service.addQuestion(question);
    }

    //GetSingleQuestionById
    @RequestMapping(value = "questions/{id}", method = RequestMethod.GET)
    public @ResponseBody
    QuestionEntity getQuestionById(@PathVariable("id") Integer id) throws Exception {
        return this.service.getQuestionById(id);
    }

    //UpdateQuestion
    @RequestMapping(value = "questions/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    QuestionEntity putQuestionById(@PathVariable("id") Integer id, @RequestBody QuestionEntity question) throws Exception {
        return this.service.updateQuestion(id, question);
    }

    //deleteQuestion
    @RequestMapping(value = "questions/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    QuestionEntity deleteQuestionById(@PathVariable("id") Integer id) throws Exception {
        return this.service.deleteQuestionById(id);
    }
}
