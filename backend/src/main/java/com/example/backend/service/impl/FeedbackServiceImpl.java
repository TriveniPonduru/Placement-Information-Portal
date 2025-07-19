package com.example.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Company;
import com.example.backend.model.Feedback;
import com.example.backend.repository.FeedbackRepository;
import com.example.backend.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository repo;

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return repo.save(feedback);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return repo.findAll();
    }

    @Override
    public List<Feedback> getByCompany(Company company) {
        return repo.findByCompany(company);
    }
}
