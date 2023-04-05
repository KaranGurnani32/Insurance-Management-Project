package com.Insurance.controller;

import com.Insurance.model.InsurancePolicy;
import com.Insurance.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    // Fetch all insurance policies
    @GetMapping
    public List<InsurancePolicy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    // Fetch a specific insurance policy by ID
    @GetMapping("/{id}")
    public InsurancePolicy getPolicyById(@PathVariable Long id) {
        return policyService.getPolicyById(id);
    }

    // Create a new insurance policy
    @PostMapping
    public InsurancePolicy createPolicy(@RequestBody InsurancePolicy policy) {
        return policyService.createPolicy(policy);
    }

    // Update an insurance policy
    @PutMapping("/{id}")
    public InsurancePolicy updatePolicy(@PathVariable Long id, @RequestBody InsurancePolicy policy) {
        return policyService.updatePolicy(id, policy);
    }

    // Delete an insurance policy
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
        return ResponseEntity.noContent().build();
    }
}
