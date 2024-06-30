package com.sacral.java.controller;

import com.sacral.java.model.CreditEligibility;
import com.sacral.java.repository.CreditEligibilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/credit")
public class CreditEligibilityController {

    private final CreditEligibilityRepository creditEligibilityRepository;

    @Autowired
    public CreditEligibilityController(CreditEligibilityRepository creditEligibilityRepository) {
        this.creditEligibilityRepository = creditEligibilityRepository;
    }

    @GetMapping("/checkEligibility")
    @ResponseBody
    public String checkCreditEligibility() {
        CreditEligibility highLimitEligibility = creditEligibilityRepository.findHighLimitEligibility();
        CreditEligibility moderateLimitEligibility = creditEligibilityRepository.findModerateLimitEligibility();

        if (highLimitEligibility != null) {
            return "Congratulations! You are eligible for a credit score with a high limit.";
        } else if (moderateLimitEligibility != null) {
            return "You are eligible for a credit score with a moderate limit.";
        } else {
            return "Sorry, you are not eligible for a credit score.";
        }
    }
}