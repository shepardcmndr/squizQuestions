/*
Created by: shepardcmndr
Date: 09.07.2020
Comments:
*/

package com.sQuiz.questionsAccess.service;

import com.sQuiz.questionsAccess.entity.Question;

import java.util.List;

public interface QuestionService {

    void saveQuestion(Question question);

    List <Question> findAll();

    List <Question> findAllByWord(String word);

    Question getQuestionByID(long id);

    void deleteQuestionByID(long id);
}
