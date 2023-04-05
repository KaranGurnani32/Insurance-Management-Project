package com.Insurance.controller;

import com.Insurance.model.InsurancePolicy;
import com.Insurance.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<InsurancePolicy> getPolicyById(@PathVariable Long id) {
        try {
            InsurancePolicy policy = policyService.getPolicyById(id);
            if (policy == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(policy, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Create a new insurance policy
    @PostMapping
    public ResponseEntity<InsurancePolicy> createPolicy(@Validated @RequestBody InsurancePolicy policy) {
        try {
            InsurancePolicy createdPolicy = policyService.createPolicy(policy);
            return new ResponseEntity<>(createdPolicy, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update an insurance policy
    @PutMapping("/{id}")
    public ResponseEntity<InsurancePolicy> updatePolicy(@PathVariable Long id, @Validated @RequestBody InsurancePolicy policy) {
        try {
            InsurancePolicy updatedPolicy = policyService.updatePolicy(id, policy);
            if (updatedPolicy == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(updatedPolicy, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete an insurance policy
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
        try {
            policyService.deletePolicy(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Exception handling
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
