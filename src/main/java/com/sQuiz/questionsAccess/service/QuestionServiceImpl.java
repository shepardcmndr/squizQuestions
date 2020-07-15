/*
Created by: shepardcmndr
Date: 09.07.2020
Comments:
*/

package com.sQuiz.questionsAccess.service;

import com.sQuiz.questionsAccess.entity.Question;
import com.sQuiz.questionsAccess.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> findAllByWord(String word) {
        return null;
    }

    @Override
    public Question getQuestionByID(long id) {
        Optional<Question> questionOptional = questionRepository.findById(id);
        Question question = null;
        if (questionOptional.isPresent()) {
            question = questionOptional.get();
        }
        return question;
    }

    @Override
    public void deleteQuestionByID(long id) {
        questionRepository.deleteById(id);
    }
}
