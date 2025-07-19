package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.backend.model.Company;
import com.example.backend.model.InterviewQuestion;
import com.example.backend.service.CompanyService;
import com.example.backend.service.InterviewQuestionService;

@RestController
@RequestMapping("/api/questions")
public class InterviewQuestionController {

    @Autowired
    private InterviewQuestionService questionService;

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public InterviewQuestion upload(@RequestBody InterviewQuestion question) {
        return questionService.saveQuestion(question);
    }

    @GetMapping("/company/{companyId}")
    public List<InterviewQuestion> getByCompany(@PathVariable Long companyId) {
        Company company = companyService.getCompanyById(companyId)
            .orElseThrow(() -> new RuntimeException("Company not found with id: " + companyId));
        return questionService.getByCompany(company);
    }
}
