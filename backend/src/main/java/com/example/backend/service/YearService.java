package com.example.backend.service;

import java.util.List;

import com.example.backend.model.Year;

public interface YearService {
    Year createYear(String value);
    List<Year> getAllYears();
    void deleteYear(Long id);
}
