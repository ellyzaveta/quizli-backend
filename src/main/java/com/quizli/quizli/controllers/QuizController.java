package com.quizli.quizli.controllers;

import com.quizli.quizli.models.Quiz;
import com.quizli.quizli.services.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
@CrossOrigin
public class QuizController {

    @Autowired
    private QuizServiceImpl quizService;

    public QuizController(QuizServiceImpl quizService) {
        this.quizService = quizService;
    }

    @PutMapping("/")
    public Quiz putQuiz(@RequestBody Quiz quiz) {
        return quizService.putQuiz(quiz);
    }

    @PostMapping("/")
    public Quiz postQuiz(@RequestBody Quiz quiz) {
        return quizService.postQuiz(quiz);
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable String id) {
        quizService.deleteQuiz(id);
    }

    @GetMapping("/{id}")
    public Quiz findById(@PathVariable String id) {
        return quizService.findById(id);
    }

    @GetMapping("/form/{slug}")
    public Quiz findBySlug(@PathVariable String slug) {
        return quizService.findBySlug(slug);
    }

    @GetMapping("/edit/{code}")
    public Quiz findByCode(@PathVariable String code) {
        return quizService.findByCode(code);
    }

}
