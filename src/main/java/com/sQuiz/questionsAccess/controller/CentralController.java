/*
Created by: shepardcmndr
Date: 09.07.2020
Comments:
*/

package com.sQuiz.questionsAccess.controller;

import com.sQuiz.questionsAccess.entity.Question;
import com.sQuiz.questionsAccess.service.QuestionService;
import com.sQuiz.questionsAccess.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/questions")
public class CentralController {

    TagService tagService;
    QuestionService questionService;

    @Autowired
    public CentralController(TagService tagService, QuestionService questionService) {
        this.tagService = tagService;
        this.questionService = questionService;
    }

    // CREATE
    @GetMapping("/addQuestion")
    public String showQuestionAddForm(Model model) {
        Question question = new Question();
        model.addAttribute("question", question);
        return "question-add-form";
    }

    @PostMapping("/addQuestion")
    public String addQuestion(@ModelAttribute(name = "question") Question question) {
        questionService.createQuestion(question);

        return "redirect:/questions/listQuestions";
    }

    // READ
    @GetMapping("/listQuestions")
    public String listQuestions(Model model) {
        List<Question> questions = questionService.findAll();
        model.addAttribute("questions", questions);

        return "questions-page";
    }

    // UPDATE
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("questionId") int questionId,
                                    Model model) {
        Question question = questionService.getQuestionByID(questionId);
        model.addAttribute("question", question);

        return "question-add-form";
    }

    // DELETE
    @GetMapping("/deleteQuestion")
    public String deleteQuestion(@RequestParam("questionId") int questionId) {
        questionService.deleteQuestionByID(questionId);

        return "redirect:/questions/listQuestions";
    }
}
