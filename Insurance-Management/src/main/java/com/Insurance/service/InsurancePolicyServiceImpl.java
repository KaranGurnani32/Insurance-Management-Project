package com.Insurance.service;

import com.Insurance.model.InsurancePolicy;
import com.Insurance.model.InsurancePolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {
    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    @Override
    public List<InsurancePolicy> getAllPolicies() {
        return insurancePolicyRepository.findAll();
    }

    @Override
    public InsurancePolicy getPolicyById(Long id) {
        return insurancePolicyRepository.findById(id).orElse(null);
    }

    @Override
    public InsurancePolicy createPolicy(InsurancePolicy policy) {
        return insurancePolicyRepository.save(policy);
    }

    @Override
    public InsurancePolicy updatePolicy(Long id, InsurancePolicy policy) {
        InsurancePolicy existingPolicy = insurancePolicyRepository.findById(id).orElse(null);
        if (existingPolicy != null) {
            existingPolicy.setPolicyNumber(policy.getPolicyNumber());
            existingPolicy.setCoverageAmount(policy.getCoverageAmount());
            existingPolicy.setPremium(policy.getPremium());
            existingPolicy.setStartDate(policy.getStartDate());
            existingPolicy.setEndDate(policy.getEndDate());
            return insurancePolicyRepository.save(existingPolicy);
        } else {
            return null;
        }
    }

    @Override
    public void deletePolicy(Long id) {
        insurancePolicyRepository.deleteById(id);
    }
}

