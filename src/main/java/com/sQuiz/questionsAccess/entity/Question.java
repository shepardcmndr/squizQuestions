/*
Created by: shepardcmndr
Date: 09.07.2020
Comments:
*/

package com.sQuiz.questionsAccess.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private long questionId;

    @NotNull
    @Size(max = 300, message = "Question is too long (max - 300)")
    @Column(name = "question_text")
    private String questionText;

    @NotNull
    @Size(max = 400, message = "Answer is too long (max - 400)")
    @Column(name = "answer")
    private String answer;

    @Size(max = 256)
    @Column(name = "pics_address")
    private String picsAddress;

    @Max(value = 128, message = "Value is too big (max - 128)")
    @Min(0)
    @Column(name = "difficulty")
    private byte difficulty;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "tags")
    private String tags;

    @Override
    public String toString() {
        return "Question [" +
                "id=" + questionId +
                ", questionText=" + questionText +
                ", answer=" + answer +
                ", picsAddress=" + picsAddress +
                ", difficulty=" + difficulty +
                ", creationDate=" + creationDate +
                ']';
    }

    public Question(long questionId,
                    @Size(max = 300, message = "Question is too long (max - 300)") String questionText,
                    @Size(max = 400, message = "Answer is too long (max - 400)") String answer,
                    @Size(max = 256) String picsAddress, @Max(value = 128, message = "Value is too big (max - 128)")
                    @Min(0) byte difficulty, Date creationDate, String tags) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.answer = answer;
        this.picsAddress = picsAddress;
        this.difficulty = difficulty;
        this.creationDate = creationDate;
        this.tags = tags;
    }

    public Question() {
    }

    public void addTag(String tag) {
        if (!tags.contains(tag)) {
            tags += ", " + tag;
        }
    }

    public List<String> getTagList() {
        List<String> tagList;
        String[] split = this.tags.split(", ");
        tagList = Arrays.asList(split);
        return tagList;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPicsAddress() {
        return picsAddress;
    }

    public void setPicsAddress(String picsAddress) {
        this.picsAddress = picsAddress;
    }

    public byte getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(byte difficulty) {
        this.difficulty = difficulty;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
