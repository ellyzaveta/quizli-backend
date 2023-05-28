package com.quizli.quizli.services;

import com.quizli.quizli.models.Quiz;

public interface QuizService {
    Quiz putQuiz(Quiz quiz);
    Quiz postQuiz(Quiz quiz);
    void deleteQuiz(String id);
    Quiz findById(String id);
    Quiz findBySlug(String slug);
    Quiz findByCode(String code);
}
