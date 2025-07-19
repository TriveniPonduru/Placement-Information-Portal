package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.backend.model.Company;
import com.example.backend.model.Feedback;
import com.example.backend.service.FeedbackService;

@RestController
@RequestMapping("/api/feedbacks")
@CrossOrigin(origins = "*") // Optional: allows frontend CORS
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public Feedback submit(@RequestBody Feedback feedback) {
        return feedbackService.saveFeedback(feedback);
    }

    @GetMapping("/company/{companyId}")
    public List<Feedback> getByCompany(@PathVariable Long companyId) {
        // Create a minimal Company object with only ID for lookup
        Company company = new Company();
        company.setId(companyId);
        return feedbackService.getByCompany(company);
    }
}
