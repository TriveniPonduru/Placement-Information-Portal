// Filename: InterviewQuestionServiceImpl.java
package com.example.backend.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend.model.Company;
import com.example.backend.model.InterviewQuestion;
import com.example.backend.repository.InterviewQuestionRepository;
import com.example.backend.service.InterviewQuestionService;

@Service
public class InterviewQuestionServiceImpl implements InterviewQuestionService {

    @Autowired
    private InterviewQuestionRepository repo;

    @Override
    public InterviewQuestion saveQuestion(InterviewQuestion question) {
        return repo.save(question);
    }

    @Override
    public List<InterviewQuestion> getByCompany(Company company) {
        return repo.findByCompany(company);
    }
}
