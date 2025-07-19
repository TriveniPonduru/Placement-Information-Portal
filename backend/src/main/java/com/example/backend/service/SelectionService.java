package com.example.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Company;
import com.example.backend.model.Selection;
import com.example.backend.model.Student;
import com.example.backend.repository.SelectionRepository;

@Service
public class SelectionService {

    @Autowired
    private SelectionRepository selectionRepository;

    public Selection saveSelection(Selection selection) {
        return selectionRepository.save(selection);
    }

    public List<Selection> getByCompany(Company company) {
        return selectionRepository.findByCompany(company);
    }

    public List<Selection> getByStudent(Student student) {
        return selectionRepository.findByStudent(student);
    }

    public List<Selection> getByYear(int year) {
        return selectionRepository.findByYear(year);
    }
}
