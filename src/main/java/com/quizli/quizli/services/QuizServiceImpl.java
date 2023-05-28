package com.quizli.quizli.services;

import com.quizli.quizli.models.Quiz;
import com.quizli.quizli.repositories.QuizRepository;
import com.quizli.quizli.utils.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz putQuiz(Quiz quiz) {
        Quiz oldQuiz = quizRepository.findById(quiz.getId()).orElse(null);

        assert oldQuiz != null;
        oldQuiz.setQuizName(quiz.getQuizName());
        oldQuiz.setQuizDescription(quiz.getQuizDescription());
        oldQuiz.setCode(quiz.getCode());

        String originalUrl = Data.convertToSlug(quiz.getQuizName());
        String url = originalUrl;
        int count = 1;

        while (quizRepository.existsByUrl(url)) {
            url = originalUrl + "-" + count;
            count++;
        }

        oldQuiz.setUrl(url);

        return quizRepository.save(oldQuiz);
    }

    @Override
    public Quiz postQuiz(Quiz quiz) {
        quiz.setUrl(Data.convertToSlug(quiz.getQuizName()));
        quiz.setCode(Data.generateCode());

        return this.quizRepository.save(quiz);
    }

    @Override
    public void deleteQuiz(String id) {
        quizRepository.deleteById(id);
    }

    @Override
    public Quiz findById(String id) {
        return quizRepository.findById(id).orElse(null);
    }

    @Override
    public Quiz findBySlug(String slug) {
        return quizRepository.findQuizByUrl(slug);
    }

    @Override
    public Quiz findByCode(String code) {
        return quizRepository.findQuizByCode(code);
    }

}
