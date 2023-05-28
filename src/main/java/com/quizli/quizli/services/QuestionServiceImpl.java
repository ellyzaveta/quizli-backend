package com.quizli.quizli.services;

import com.quizli.quizli.models.Question;
import com.quizli.quizli.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question putQuestion(Question question) {
        Question oldQuestion = questionRepository.findById(question.getId()).orElse(null);
        assert oldQuestion != null;

        oldQuestion.setText(question.getText());
        oldQuestion.setOptions(question.getOptions());

        return questionRepository.save(oldQuestion);
    }

    @Override
    public Question postQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(String id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Question findById(String id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Question> findAllQuestionsByQuizId(String id) {
        return questionRepository.findAllByQuizId(id);
    }
}
