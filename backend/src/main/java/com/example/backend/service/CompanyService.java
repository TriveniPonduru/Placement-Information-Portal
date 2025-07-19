package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import com.example.backend.dto.CompanyDTO;
import com.example.backend.model.Company;

public interface CompanyService {

    /**
     * Saves a new company using data from a CompanyDTO.
     * @param companyDTO the company data transfer object containing company details and yearId.
     * @return the saved Company entity.
     */
    Company saveCompany(CompanyDTO companyDTO);

    /**
     * Retrieves all companies.
     * @return a list of all Company entities.
     */
    List<Company> getAllCompanies();

    /**
     * Retrieves companies associated with a specific year.
     * @param yearId the ID of the year.
     * @return a list of Company entities for the given year.
     */
    List<Company> getCompaniesByYear(Long yearId);

    /**
     * Retrieves a company by its ID.
     * @param id the company ID.
     * @return an Optional containing the Company entity if found, or empty otherwise.
     */
    Optional<Company> getCompanyById(Long id);

    /**
     * Deletes a company by its ID.
     * @param id the company ID to delete.
     */
    void deleteCompany(Long id);
     Company updateCompany(Long id, CompanyDTO dto);
}
