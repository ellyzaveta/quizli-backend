package com.quizli.quizli.repositories;

import com.quizli.quizli.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAllByQuizID(String quizId);
}
