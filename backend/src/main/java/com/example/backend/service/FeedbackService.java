package com.example.backend.service;

import java.util.List;

import com.example.backend.model.Company;
import com.example.backend.model.Feedback;

public interface FeedbackService {
    Feedback saveFeedback(Feedback feedback);
    List<Feedback> getAllFeedbacks();
    List<Feedback> getByCompany(Company company);
}
