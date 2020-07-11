/*
Created by: shepardcmndr
Date: 09.07.2020
Comments:
*/

package com.sQuiz.questionsAccess.service;

import com.sQuiz.questionsAccess.entity.Tag;
import com.sQuiz.questionsAccess.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public List<Tag> findByWord(String word) {
        return null;
    }

    @Override
    public Tag findById(long id) {
        Optional<Tag> tagOptional = tagRepository.findById(id);
        Tag tag = null;
        if (tagOptional.isPresent()) {
            tag = tagOptional.get();
        }
        return tag;
    }

    @Override
    public Tag updateTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTagById(long id) {
        tagRepository.deleteById(id);
    }
}
