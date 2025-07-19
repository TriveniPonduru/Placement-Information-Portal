package com.example.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.model.Year;
import com.example.backend.repository.YearRepository;
import com.example.backend.service.YearService;

@Service
public class YearServiceImpl implements YearService {

    @Autowired
    private YearRepository yearRepository;

    @Override
    public Year createYear(String value) {
        try {
            int numericValue = Integer.parseInt(value.trim());

            if (yearRepository.existsByValue(numericValue)) {
                throw new RuntimeException("Year " + numericValue + " already exists.");
            }

            Year year = new Year(numericValue);
            return yearRepository.save(year);

        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid year format: '" + value + "'. Please enter a valid number.");
        }
    }

    @Override
    public List<Year> getAllYears() {
        return yearRepository.findAll();
    }

    @Override
    public void deleteYear(Long id) {
        if (!yearRepository.existsById(id)) {
            throw new RuntimeException("Year with ID " + id + " does not exist.");
        }
        yearRepository.deleteById(id);
    }
}
