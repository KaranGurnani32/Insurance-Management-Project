package com.Insurance.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyNumber;
    private String type;
    private double coverageAmount;
    private double premium;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    private Client client;

    public InsurancePolicy(String policyNumber, String type, double coverageAmount,
                           double premium, LocalDate startDate, LocalDate endDate, Client client) {
        this.policyNumber = policyNumber;
        this.type = type;
        this.coverageAmount = coverageAmount;
        this.premium = premium;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
    }
}
