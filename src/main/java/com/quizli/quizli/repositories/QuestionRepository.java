package com.quizli.quizli.repositories;

import com.quizli.quizli.models.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Question, String> {
    List<Question> findAllByQuizId(String quizId);
}
