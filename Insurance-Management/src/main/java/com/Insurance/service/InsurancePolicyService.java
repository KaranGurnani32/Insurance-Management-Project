package com.Insurance.service;

import com.Insurance.model.InsurancePolicy;

import java.util.List;


public interface InsurancePolicyService {

    List<InsurancePolicy> getAllPolicies();

    InsurancePolicy getPolicyById(Long id);

    InsurancePolicy createPolicy(InsurancePolicy policy);

    InsurancePolicy updatePolicy(Long id, InsurancePolicy policy);

    void deletePolicy(Long id);
}
