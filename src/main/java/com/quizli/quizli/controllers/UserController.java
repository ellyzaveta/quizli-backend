package com.quizli.quizli.controllers;

import com.quizli.quizli.models.Question;
import com.quizli.quizli.models.Quiz;
import com.quizli.quizli.models.User;
import com.quizli.quizli.models.UserAnswer;
import com.quizli.quizli.services.QuestionServiceImpl;
import com.quizli.quizli.services.QuizServiceImpl;
import com.quizli.quizli.services.UserServiceImpl;
import com.quizli.quizli.utils.Data;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private QuizServiceImpl quizService;

    @Autowired
    private QuestionServiceImpl questionService;

    public UserController(UserServiceImpl userService, QuizServiceImpl quizService, QuestionServiceImpl questionService) {
        this.userService = userService;
        this.quizService = quizService;
    }

    @PostMapping("/")
    public User postUser(@RequestBody User user, HttpServletRequest request) {
        String userIP = request.getRemoteAddr();

        Quiz quiz = quizService.findById(user.getQuizID());
        List<Question> questions = questionService.findAllQuestionsByQuizId(quiz.getId());
        List<UserAnswer> userAnswers = user.getUserAnswer();

        System.out.println(user);

        int maxScore = 0;
        int userScore = 0;
        for(Question question : questions) {
            UserAnswer userAnswer = Data.getUserAnswerByQuestionId(userAnswers, question.getId());
            assert userAnswer != null;
            if(question.getOptions().equals(userAnswer.getOptions())) userScore++;
            maxScore++;
        }

        user.setUserIP(userIP);
        user.setScore(String.valueOf(userScore));
        user.setMaxScore(String.valueOf(maxScore));

        return userService.postUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @GetMapping("/users/{quizId}")
    public List<User> getUsersByQuizId(@PathVariable String quizId) {
        return userService.getUsersByQuizId(quizId);
    }

}
