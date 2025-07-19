package com.example.backend.repository;

import java.util.List;
import com.example.backend.model.Year;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    
    // Fetch companies based on Year ID (foreign key relationship)
    List<Company> findByYear(Year year);

}
