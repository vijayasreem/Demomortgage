package com.sacral.java.service;

import com.sacral.java.model.DocumentVerification;
import com.sacral.java.repository.DocumentVerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentVerificationService {

    private final DocumentVerificationRepository documentVerificationRepository;

    @Autowired
    public DocumentVerificationService(DocumentVerificationRepository documentVerificationRepository) {
        this.documentVerificationRepository = documentVerificationRepository;
    }

    public boolean isIdentityAndAddressVerified() {
        return documentVerificationRepository.isIdentityAndAddressVerified();
    }

    public boolean isDocumentVerificationIncomplete() {
        return documentVerificationRepository.isDocumentVerificationIncomplete();
    }

    public boolean isEligibleForHighLimitCreditScore() {
        return documentVerificationRepository.isEligibleForHighLimitCreditScore();
    }

    public boolean isEligibleForModerateLimitCreditScore() {
        return documentVerificationRepository.isEligibleForModerateLimitCreditScore();
    }
}