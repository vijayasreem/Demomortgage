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

    public DocumentVerification findVerifiedDocument() {
        return documentVerificationRepository.findVerifiedDocument();
    }

    public DocumentVerification findIncompleteDocument() {
        return documentVerificationRepository.findIncompleteDocument();
    }

    public DocumentVerification findHighLimitEligible() {
        return documentVerificationRepository.findHighLimitEligible();
    }

    public DocumentVerification findModerateLimitEligible() {
        return documentVerificationRepository.findModerateLimitEligible();
    }
}