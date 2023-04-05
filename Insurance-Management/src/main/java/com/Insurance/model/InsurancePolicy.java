package com.Insurance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class InsurancePolicy {

    // Represents an insurance policy with properties like policy
    //number, type, coverage amount, premium, start date, and end date. Each policy
    //should be associated with a client.

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer policyNumber;
    private String policyType;
    private Double coverageAmount;
    private Double premium;
    private String startDate;
    private String endDate;

    public InsurancePolicy(Integer policyNumber, String policyType, Double coverageAmount, Double premium, String startDate, String endDate) {
        this.policyNumber = policyNumber;
        this.policyType = policyType;
        this.coverageAmount = coverageAmount;
        this.premium = premium;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
