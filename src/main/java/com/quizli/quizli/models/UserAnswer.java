package com.quizli.quizli.models;

import java.util.List;

public class UserAnswer {
    String questionId;
    List<Option> options;

    public UserAnswer(String questionId, List<Option> options) {
        this.questionId = questionId;
        this.options = options;
    }

    public String getQuestionId() {
        return questionId;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

}

