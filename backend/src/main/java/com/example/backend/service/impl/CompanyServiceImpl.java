package com.example.backend.service.impl;

import com.example.backend.dto.CompanyDTO;
import com.example.backend.model.Company;
import com.example.backend.model.Year;
import com.example.backend.repository.CompanyRepository;
import com.example.backend.repository.YearRepository;
import com.example.backend.service.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private YearRepository yearRepository;

    @Override
    public Company saveCompany(CompanyDTO dto) {
        Year year = yearRepository.findById(dto.getYearId())
                .orElseThrow(() -> new RuntimeException("Year not found with ID: " + dto.getYearId()));

        Company company = new Company();
        company.setName(dto.getName());
        company.setRole(dto.getRole());
        company.setAPackage(dto.getAPackage());
        company.setDescription(dto.getDescription());
        company.setYear(year);

        return companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public List<Company> getCompaniesByYear(Long yearId) {
        Year year = new Year();
        year.setId(yearId);
        return companyRepository.findByYear(year);
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    // ✅ Update company method
    @Override
    public Company updateCompany(Long id, CompanyDTO dto) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with ID: " + id));

        company.setName(dto.getName());
        company.setRole(dto.getRole());
        company.setAPackage(dto.getAPackage());
        company.setDescription(dto.getDescription());

        // If yearId is provided, update year
        if (dto.getYearId() != null) {
            Year year = yearRepository.findById(dto.getYearId())
                    .orElseThrow(() -> new RuntimeException("Year not found with ID: " + dto.getYearId()));
            company.setYear(year);
        }

        return companyRepository.save(company);
    }
}
