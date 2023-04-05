package com.Insurance.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class InsuranceClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer claimNumber;
    private String description;
    private LocalDate claimDate;
    private String claimStatus;

    public InsuranceClaim() {
    }

    public InsuranceClaim(Integer claimNumber, String description, LocalDate claimDate, String claimStatus) {
        this.claimNumber = claimNumber;
        this.description = description;
        this.claimDate = claimDate;
        this.claimStatus = claimStatus;
    }

}
