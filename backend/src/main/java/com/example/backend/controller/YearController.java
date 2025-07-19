package com.example.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Year;
import com.example.backend.service.YearService;

@RestController
@RequestMapping("/api/years")
@CrossOrigin("*")
public class YearController {

    @Autowired
    private YearService yearService;

    @PostMapping
    public Year createYear(@RequestBody Map<String, String> request) {
        return yearService.createYear(request.get("value"));
    }

    @GetMapping
    public List<Year> getYears() {
        return yearService.getAllYears();
    }

    @DeleteMapping("/{id}")
    public void deleteYear(@PathVariable Long id) {
        yearService.deleteYear(id);
    }
    
}
