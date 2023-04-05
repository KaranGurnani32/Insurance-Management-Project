package com.Insurance.service;

import com.Insurance.model.InsuranceClaim;

import java.util.List;

public interface InsuranceClaimService {

    List<InsuranceClaim> getAllClaims();

    InsuranceClaim getClaimById(Long id);

    InsuranceClaim createClaim(InsuranceClaim claim);

    InsuranceClaim updateClaim(Long id, InsuranceClaim claim);

    boolean deleteClaim(Long id);
}
