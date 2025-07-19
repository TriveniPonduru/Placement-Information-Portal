package com.example.backend.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
     Optional<Student> findByRegNo(String regNo);
    List<Student> findByCompanyId(Long companyId);
}
