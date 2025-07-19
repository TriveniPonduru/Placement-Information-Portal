package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.Selection;
import com.example.backend.service.SelectionService;

@RestController
@RequestMapping("/api/selections")
public class SelectionController {

    @Autowired
    private SelectionService selectionService;

    @PostMapping
    public Selection add(@RequestBody Selection selection) {
        return selectionService.saveSelection(selection);
    }

    @GetMapping("/year/{year}")
    public List<Selection> getByYear(@PathVariable int year) {
        return selectionService.getByYear(year);
    }
}
