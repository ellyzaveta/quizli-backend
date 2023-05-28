package com.quizli.quizli.services;

import com.quizli.quizli.models.Question;

import java.util.List;

public interface QuestionService {
    Question putQuestion(Question question);
    Question postQuestion(Question question);
    void deleteQuestion(String id);
    Question findById(String id);
    List<Question> findAllQuestionsByQuizId(String id);
}

