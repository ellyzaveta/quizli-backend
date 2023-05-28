package com.quizli.quizli.repositories;

import com.quizli.quizli.models.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizRepository extends MongoRepository<Quiz, String> {
    Quiz findQuizByUrl(String url);
    Quiz findQuizByCode(String code);
    boolean existsByUrl(String s);
}
