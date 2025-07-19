package com.example.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "years", uniqueConstraints = @UniqueConstraint(columnNames = "value"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Year {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Integer value;  // Unique year like 2023, 2024, etc.

    // Constructor for setting only ID (e.g., for foreign key references)
    public Year(Long id) {
        this.id = id;
    }

    // Constructor for setting only value (used during creation)
    public Year(int value) {
        this.value = value;
    }
}
