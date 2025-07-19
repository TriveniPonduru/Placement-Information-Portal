package com.example.backend.service;

import java.util.List;

import com.example.backend.model.Company;
import com.example.backend.model.InterviewQuestion;

public interface InterviewQuestionService {
    InterviewQuestion saveQuestion(InterviewQuestion question);
    List<InterviewQuestion> getByCompany(Company company);
}
