package com.sacral.java.controller;

import com.sacral.java.service.DocumentVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/document-verification")
public class DocumentVerificationController {

    private final DocumentVerificationService documentVerificationService;

    @Autowired
    public DocumentVerificationController(DocumentVerificationService documentVerificationService) {
        this.documentVerificationService = documentVerificationService;
    }

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to the Document Verification App!";
    }

    @GetMapping("/verify-identity-and-address")
    public String verifyIdentityAndAddress() {
        boolean isIdentityAndAddressVerified = documentVerificationService.isIdentityAndAddressVerified();
        if (isIdentityAndAddressVerified) {
            return "Identity and address verified: Yes";
        } else {
            return "Identity and address verified: No";
        }
    }

    @GetMapping("/verify-eligibility")
    public String verifyEligibility() {
        boolean isDocumentVerificationIncomplete = documentVerificationService.isDocumentVerificationIncomplete();
        if (isDocumentVerificationIncomplete) {
            return "Document verification incomplete. Not eligible for banking services.";
        } else {
            boolean isEligibleForHighLimitCreditScore = documentVerificationService.isEligibleForHighLimitCreditScore();
            boolean isEligibleForModerateLimitCreditScore = documentVerificationService.isEligibleForModerateLimitCreditScore();
            if (isEligibleForHighLimitCreditScore) {
                return "Congratulations! You are eligible for a high-limit credit score.";
            } else if (isEligibleForModerateLimitCreditScore) {
                return "You are eligible for a moderate-limit credit score.";
            } else {
                return "Not eligible for any credit score.";
            }
        }
    }
}