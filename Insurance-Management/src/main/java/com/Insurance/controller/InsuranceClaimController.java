package com.Insurance.controller;

import com.Insurance.model.InsuranceClaim;
import com.Insurance.service.InsuranceClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class InsuranceClaimController {
    @Autowired
    private InsuranceClaimService claimService;

    @GetMapping
    public ResponseEntity<List<InsuranceClaim>> getAllClaims() {
        List<InsuranceClaim> claims = claimService.getAllClaims();
        return new ResponseEntity<>(claims, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsuranceClaim> getClaimById(@PathVariable Long id) {
        InsuranceClaim claim = claimService.getClaimById(id);
        if (claim == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(claim, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createClaim(@Validated @RequestBody InsuranceClaim claim, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        InsuranceClaim createdClaim = claimService.createClaim(claim);
        return new ResponseEntity<>(createdClaim, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClaim(@PathVariable Long id, @Validated @RequestBody InsuranceClaim claim, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        InsuranceClaim updatedClaim = claimService.updateClaim(id, claim);
        if (updatedClaim == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedClaim, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Long id) {
        boolean deleted = claimService.deleteClaim(id);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Exception handling
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
