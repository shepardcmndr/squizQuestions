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

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "questions_tags",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    public void updateQuestion(Question question) {
        this.setQuestionText(question.getQuestionText());
        this.setAnswer(question.getAnswer());
        this.setDifficulty(question.getDifficulty());
        this.setCreationDate(question.getCreationDate());
        this.setTags(question.getTags());
    }

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

    public Question(String questionText, String answer, String picsAddress, byte difficulty, Date creationDate) {
        this.questionText = questionText;
        this.answer = answer;
        this.picsAddress = picsAddress;
        this.difficulty = difficulty;
        this.creationDate = new Date();
    }

    public Question() {
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
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
