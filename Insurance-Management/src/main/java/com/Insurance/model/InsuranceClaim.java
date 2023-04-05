package com.Insurance.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class InsuranceClaim {

//    Represents an insurance claim with properties like claim number,
//    description, claim date, and claim status. Each claim should be associated with
//    an insurance policy.

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String claimNumber;
    private String description;
    private String claimDate;
    private String claimStatus;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private InsurancePolicy insurancePolicy;

    public InsuranceClaim(String claimNumber, String description, String claimDate, String claimStatus, InsurancePolicy insurancePolicy) {
        this.claimNumber = claimNumber;
        this.description = description;
        this.claimDate = claimDate;
        this.claimStatus = claimStatus;
        this.insurancePolicy = insurancePolicy;
    }

}
