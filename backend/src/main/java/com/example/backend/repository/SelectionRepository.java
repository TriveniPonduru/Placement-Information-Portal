package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Company;
import com.example.backend.model.Selection;
import com.example.backend.model.Student;

public interface SelectionRepository extends JpaRepository<Selection, Long> {
    List<Selection> findByCompany(Company company);
    List<Selection> findByStudent(Student student);
    List<Selection> findByYear(int year);
}
