package com.example.backend.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CompanyDTO {
    private String name;
    private String role;
    private BigDecimal aPackage;
    private String description;
    private Long yearId;
}
