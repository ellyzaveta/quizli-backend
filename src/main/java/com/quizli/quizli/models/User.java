package com.quizli.quizli.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    String id;
    String userIP;
    String quizID;
    List<UserAnswer> userAnswer;
    String score;
    String maxScore;
}

