package com.one.mpp.Controller;

import com.one.mpp.Entity.AnswerEntity;
import com.one.mpp.Services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AnswerController {

    @Autowired
    private AnswerService service;

    //getAnswers
    @RequestMapping(value = "answers", method = RequestMethod.GET)
    public @ResponseBody
    List<AnswerEntity> getAnswers() {
        return this.service.getAllAnswers();
    }

    //postAnswers
    @RequestMapping(value = "answers", method = RequestMethod.POST)
    public @ResponseBody     AnswerEntity postAnswers(@RequestBody AnswerEntity answer) throws Exception {
        return this.service.postAnswer(answer);
    }

    //getAnswerByID
    @RequestMapping(value = "answers/{id}", method = RequestMethod.GET)
    public @ResponseBody
    AnswerEntity getAnswerById(@PathVariable("id") Integer answer_id) throws Exception {
        return this.service.getAnswerById(answer_id);

    }

    //UpdateAnswer
    @RequestMapping(value = "answers/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    AnswerEntity updateAnswerById(@PathVariable("id") Integer answer_id, AnswerEntity answer) throws Exception {
        return this.service.updateAnswerById(answer_id, answer);
    }

    //deleteAnswer
    @RequestMapping(value = "answers/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    AnswerEntity deleteAnswerById(@PathVariable("answer_id") Integer answer_id) throws Exception {
        return this.service.deleteAnswerById(answer_id);
    }

}
