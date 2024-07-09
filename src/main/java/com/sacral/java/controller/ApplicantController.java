package com.sacral.java.controller;

import com.sacral.java.model.Applicant;
import com.sacral.java.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {

    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping("/{applicantId}/credit-score")
    public int getCreditScoreById(@PathVariable Long applicantId) {
        return applicantService.getCreditScoreById(applicantId);
    }

    @GetMapping("/{applicantId}/loan-amount")
    public double getLoanAmountById(@PathVariable Long applicantId) {
        return applicantService.getLoanAmountById(applicantId);
    }

    @GetMapping("/{applicantId}/interest-rate")
    public double getInterestRateById(@PathVariable Long applicantId) {
        return applicantService.getInterestRateById(applicantId);
    }

    // Add more endpoints for other business methods as needed

    @PostMapping("/pre-qualify")
    public void preQualifyApplicant(@RequestBody Applicant applicant) {
        // Perform credit check and pre-qualification logic
        // Save pre-qualification results
        // Send notification to the applicant
    }
}