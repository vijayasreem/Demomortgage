package com.sacral.java.controller;

import com.sacral.java.model.DocumentVerification;
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

    @GetMapping("/verified")
    public DocumentVerification findVerifiedDocument() {
        return documentVerificationService.findVerifiedDocument();
    }

    @GetMapping("/incomplete")
    public DocumentVerification findIncompleteDocument() {
        return documentVerificationService.findIncompleteDocument();
    }

    @GetMapping("/high-limit-eligible")
    public DocumentVerification findHighLimitEligible() {
        return documentVerificationService.findHighLimitEligible();
    }

    @GetMapping("/moderate-limit-eligible")
    public DocumentVerification findModerateLimitEligible() {
        return documentVerificationService.findModerateLimitEligible();
    }
}