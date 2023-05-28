package com.quizli.quizli.services;

import com.quizli.quizli.models.User;

import java.util.List;

public interface UserService {
    User postUser(User user);
    User getUser(String id);
    List<User> getUsersByQuizId(String id);
}

