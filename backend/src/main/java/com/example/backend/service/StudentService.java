package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import com.example.backend.model.Student;

public interface StudentService {

    Student saveStudent(Student student);

    List<Student> getAllStudents();

    Optional<Student> findByRegNo(String regNo);

    List<Student> getStudentsByCompanyId(Long companyId);  // 👈 useful if not added

    void deleteStudent(Long id);  // 👈 ADD THIS
}
