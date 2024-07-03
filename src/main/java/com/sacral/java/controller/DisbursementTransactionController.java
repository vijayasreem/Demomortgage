package com.sacral.java.controller;

import com.sacral.java.model.DisbursementTransaction;
import com.sacral.java.service.DisbursementTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/disbursements")
public class DisbursementTransactionController {

    private final DisbursementTransactionService disbursementTransactionService;

    @Autowired
    public DisbursementTransactionController(DisbursementTransactionService disbursementTransactionService) {
        this.disbursementTransactionService = disbursementTransactionService;
    }

    @GetMapping("/valid")
    public List<DisbursementTransaction> findValidDisbursements() {
        return disbursementTransactionService.findValidDisbursements();
    }

    @GetMapping("/invalid")
    public List<DisbursementTransaction> findInvalidDisbursements() {
        return disbursementTransactionService.findInvalidDisbursements();
    }

    @GetMapping("/auto-approved")
    public List<DisbursementTransaction> findAutomaticallyApprovedPayments() {
        return disbursementTransactionService.findAutomaticallyApprovedPayments();
    }

    @GetMapping("/approval-required")
    public List<DisbursementTransaction> findPaymentsRequiringApproval() {
        return disbursementTransactionService.findPaymentsRequiringApproval();
    }

    @GetMapping("/successful")
    public List<DisbursementTransaction> findSuccessfulDisbursements() {
        return disbursementTransactionService.findSuccessfulDisbursements();
    }

    @GetMapping("/invalid-vendor")
    public List<DisbursementTransaction> findInvalidVendorInformation() {
        return disbursementTransactionService.findInvalidVendorInformation();
    }

    @GetMapping("/insufficient-funds")
    public List<DisbursementTransaction> findInsufficientFundsDisbursements() {
        return disbursementTransactionService.findInsufficientFundsDisbursements();
    }

    // Additional methods for logging, notifications, and monitoring can be added here

}