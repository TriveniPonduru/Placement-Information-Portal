package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Company;
import com.example.backend.model.Feedback;
import com.example.backend.model.Student;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByCompany(Company company);
    List<Feedback> findByStudent(Student student);
    List<Feedback> findByCompanyId(Long companyId);
    

}
