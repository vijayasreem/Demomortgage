package com.sacral.java.service;

import com.sacral.java.model.DisbursementTransaction;
import com.sacral.java.repository.DisbursementTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisbursementTransactionService {

    private final DisbursementTransactionRepository disbursementTransactionRepository;

    @Autowired
    public DisbursementTransactionService(DisbursementTransactionRepository disbursementTransactionRepository) {
        this.disbursementTransactionRepository = disbursementTransactionRepository;
    }

    public List<DisbursementTransaction> findValidDisbursements() {
        return disbursementTransactionRepository.findValidDisbursements();
    }

    public List<DisbursementTransaction> findInvalidDisbursements() {
        return disbursementTransactionRepository.findInvalidDisbursements();
    }

    public List<DisbursementTransaction> findAutomaticallyApprovedPayments() {
        return disbursementTransactionRepository.findAutomaticallyApprovedPayments();
    }

    public List<DisbursementTransaction> findPaymentsRequiringApproval() {
        return disbursementTransactionRepository.findPaymentsRequiringApproval();
    }

    public List<DisbursementTransaction> findSuccessfulDisbursements() {
        return disbursementTransactionRepository.findSuccessfulDisbursements();
    }

    public List<DisbursementTransaction> findInvalidVendorInformation() {
        return disbursementTransactionRepository.findInvalidVendorInformation();
    }

    public List<DisbursementTransaction> findInsufficientFundsDisbursements() {
        return disbursementTransactionRepository.findInsufficientFundsDisbursements();
    }

    // Additional methods for logging, notifications, and monitoring can be added here

}