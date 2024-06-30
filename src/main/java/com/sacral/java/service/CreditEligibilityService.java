package com.sacral.java.service;

import com.sacral.java.model.CreditEligibility;
import com.sacral.java.repository.CreditEligibilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditEligibilityService {

    private final CreditEligibilityRepository creditEligibilityRepository;

    @Autowired
    public CreditEligibilityService(CreditEligibilityRepository creditEligibilityRepository) {
        this.creditEligibilityRepository = creditEligibilityRepository;
    }

    public void checkCreditEligibility() {
        CreditEligibility highLimitEligibility = creditEligibilityRepository.findHighLimitEligibility();
        CreditEligibility moderateLimitEligibility = creditEligibilityRepository.findModerateLimitEligibility();

        if (highLimitEligibility != null) {
            System.out.println("Congratulations! You are eligible for a credit score with a high limit.");
        } else if (moderateLimitEligibility != null) {
            System.out.println("You are eligible for a credit score with a moderate limit.");
        } else {
            System.out.println("Sorry, you are not eligible for a credit score.");
        }

        // Close any resources here
    }
}