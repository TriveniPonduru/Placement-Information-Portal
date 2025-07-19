package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.backend.dto.CompanyDTO;
import com.example.backend.model.Company;
import com.example.backend.service.CompanyService;
import com.example.backend.service.FileStorageService;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin(origins = "http://localhost:3000")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private FileStorageService fileStorageService; // ✅ Injected missing service

    @PostMapping
    public Company addCompany(@RequestBody CompanyDTO companyDTO) {
        System.out.println("📝 Adding new company: " + companyDTO.getName());
        Company savedCompany = companyService.saveCompany(companyDTO);
        System.out.println("✅ Company added with ID: " + savedCompany.getId());
        return savedCompany;
    }

    @GetMapping("/year/{yearId}")
    public List<Company> getCompaniesByYear(@PathVariable Long yearId) {
        System.out.println("📋 Fetching companies for year: " + yearId);
        List<Company> companies = companyService.getCompaniesByYear(yearId);
        System.out.println("📊 Found " + companies.size() + " companies for year " + yearId);
        return companies;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id) {
        System.out.println("🔍 Fetching company with ID: " + id);
        try {
            Company company = companyService.getCompanyById(id)
                    .orElseThrow(() -> new RuntimeException("Company not found with ID: " + id));
            System.out.println("✅ Company found: " + company.getName());
            return ResponseEntity.ok(company);
        } catch (Exception e) {
            System.out.println("❌ Error fetching company: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<Company> getAllCompanies() {
        System.out.println("📋 Fetching all companies");
        List<Company> companies = companyService.getAllCompanies();
        System.out.println("📊 Total companies found: " + companies.size());
        companies.forEach(c -> System.out.println("  - ID: " + c.getId() + ", Name: " + c.getName()));
        return companies;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody CompanyDTO companyDTO) {
        System.out.println("📝 Updating company with ID: " + id);
        try {
            Company updatedCompany = companyService.updateCompany(id, companyDTO);
            System.out.println("✅ Company updated successfully");
            return ResponseEntity.ok(updatedCompany);
        } catch (Exception e) {
            System.out.println("❌ Error updating company: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        System.out.println("🗑️ Deleting company with ID: " + id);
        try {
            companyService.deleteCompany(id);
            System.out.println("✅ Company deleted successfully");
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println("❌ Error deleting company: " + e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    // ✅ PDF upload endpoint
    @PostMapping("/{companyId}/upload-pdf")
    public ResponseEntity<String> uploadPDF(@PathVariable Long companyId, @RequestParam("file") MultipartFile file) {
        System.out.println("📄 Uploading PDF for company ID: " + companyId);
        try {
            String filePath = fileStorageService.storeFile(file, companyId);
            String pdfUrl = "/files/" + filePath;
            return ResponseEntity.ok("{\"pdfUrl\": \"" + pdfUrl + "\"}");
        } catch (Exception e) {
            System.out.println("❌ Error uploading file: " + e.getMessage());
            return ResponseEntity.badRequest().body("{\"error\": \"File upload failed\"}");
        }
    }
    
    
   @GetMapping("/{companyId}/files")
public ResponseEntity<List<String>> getUploadedFiles(@PathVariable Long companyId) {
    try {
        List<String> files = fileStorageService.listFilesForCompany(companyId);
        List<String> fileUrls = files.stream()
                .map(file -> "http://localhost:8081/files/" + file)  // ✅ Full URL here
                .toList();
        return ResponseEntity.ok(fileUrls);
    } catch (Exception e) {
        System.out.println("❌ Error listing files: " + e.getMessage());
        return ResponseEntity.internalServerError().build();
    }
}

@DeleteMapping("/{companyId}/files/{fileName}")
public ResponseEntity<Void> deletePdf(
        @PathVariable Long companyId,
        @PathVariable String fileName) {
    try {
        boolean deleted = fileStorageService.deleteFile(fileName);
        if (deleted) {
            System.out.println("✅ File deleted: " + fileName);
            return ResponseEntity.ok().build();
        } else {
            System.out.println("❌ File not found: " + fileName);
            return ResponseEntity.notFound().build();
        }
    } catch (Exception e) {
        System.out.println("❌ Error deleting file: " + e.getMessage());
        return ResponseEntity.internalServerError().build();
    }
}


}
