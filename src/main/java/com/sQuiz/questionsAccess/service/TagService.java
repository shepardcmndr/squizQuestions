/*
Created by: shepardcmndr
Date: 09.07.2020
Comments:
*/

package com.sQuiz.questionsAccess.service;

import com.sQuiz.questionsAccess.entity.Tag;

import java.util.List;

public interface TagService {

    void saveTag(Tag tag);

    List<Tag> findAll();

    List<Tag> findByWord(String word);

    Tag findById(long id);

    void deleteTagById(long id);
}
