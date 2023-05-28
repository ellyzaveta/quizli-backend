package com.quizli.quizli.controllers;

import com.quizli.quizli.models.Question;
import com.quizli.quizli.services.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@CrossOrigin
public class QuestionController {

    @Autowired
    private QuestionServiceImpl questionService;

    public QuestionController(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

    @PutMapping("/")
    public Question putQuestion(@RequestBody Question question) {
        return questionService.putQuestion(question);
    }

    @PostMapping("/")
    public Question postQuestion(@RequestBody Question question) {
        return questionService.postQuestion(question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable String id) {
        questionService.deleteQuestion(id);
    }


    @GetMapping("/per/{id}")
    public Question findById(@PathVariable String id) {
        return questionService.findById(id);
    }

    @GetMapping("/{id}")
    public List<Question> findAllByQuizId(@PathVariable String id) {
        return questionService.findAllQuestionsByQuizId(id);
    }
}
