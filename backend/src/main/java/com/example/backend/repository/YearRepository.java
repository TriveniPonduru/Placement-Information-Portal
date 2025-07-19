package com.example.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Year;

public interface YearRepository extends JpaRepository<Year, Long> {
    boolean existsByValue(Integer value);
}
