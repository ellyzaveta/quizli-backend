package com.quizli.quizli.utils;

import com.quizli.quizli.models.UserAnswer;

import java.security.SecureRandom;
import java.util.List;

public class Data {

    public static String convertToSlug(String text) {
        if(text == null) return "test";
        else {
            text = text.trim();
            text = text.toLowerCase();
            text = text.replaceAll("[^a-z0-9]", "-");
            text = text.replaceAll("-+", "-");
        }

        return text;
    }

    public static String generateCode() {
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int CODE_LENGTH = 8;
        SecureRandom random = new SecureRandom();
        StringBuilder codeBuilder = new StringBuilder(CODE_LENGTH);

        for (int i = 0; i < CODE_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            codeBuilder.append(randomChar);
        }

        return codeBuilder.toString();
    }

    public static UserAnswer getUserAnswerByQuestionId(List<UserAnswer> userAnswers, String questionId) {
        for (UserAnswer userAnswer : userAnswers) {
            if (userAnswer.getQuestionId().equals(questionId)) {
                return userAnswer;
            }
        }
        return null;
    }
}
