package com.Insurance.service;

import com.Insurance.model.InsuranceClaim;
import com.Insurance.model.InsuranceClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceClaimServiceImpl implements InsuranceClaimService {

    @Autowired
    private InsuranceClaimRepository insuranceClaimRepository;

    @Override
    public List<InsuranceClaim> getAllClaims() {
        return insuranceClaimRepository.findAll();
    }

    @Override
    public InsuranceClaim getClaimById(Long id) {
        Optional<InsuranceClaim> optionalClaim = insuranceClaimRepository.findById(id);
        return optionalClaim.orElse(null);
    }

    @Override
    public InsuranceClaim createClaim(InsuranceClaim claim) {
        return insuranceClaimRepository.save(claim);
    }

    @Override
    public InsuranceClaim updateClaim(Long id, InsuranceClaim updatedClaim) {
        Optional<InsuranceClaim> optionalClaim = insuranceClaimRepository.findById(id);
        if (optionalClaim.isPresent()) {
            InsuranceClaim existingClaim = optionalClaim.get();
            existingClaim.setClaimNumber(updatedClaim.getClaimNumber());
            existingClaim.setDescription(updatedClaim.getDescription());
            existingClaim.setClaimDate(updatedClaim.getClaimDate());
            existingClaim.setClaimStatus(updatedClaim.getClaimStatus());
//            existingClaim.setInsurancePolicy(updatedClaim.getInsurancePolicy());
            return insuranceClaimRepository.save(existingClaim);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteClaim(Long id) {
        Optional<InsuranceClaim> optionalClaim = insuranceClaimRepository.findById(id);
        if (optionalClaim.isPresent()) {
            insuranceClaimRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
