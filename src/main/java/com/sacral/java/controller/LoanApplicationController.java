package com.sacral.java.controller;

import com.sacral.java.model.LoanApplication;
import com.sacral.java.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan-applications")
public class LoanApplicationController {

    private final LoanApplicationService loanApplicationService;

    @Autowired
    public LoanApplicationController(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    @GetMapping("/customer/{customerId}")
    public LoanApplication findByCustomerId(@PathVariable Long customerId) {
        return loanApplicationService.findByCustomerId(customerId);
    }

    @GetMapping("/pending")
    public List<LoanApplication> findPendingApplications() {
        return loanApplicationService.findPendingApplications();
    }

    @GetMapping("/approved")
    public List<LoanApplication> findApprovedApplications() {
        return loanApplicationService.findApprovedApplications();
    }

    @GetMapping("/rejected")
    public List<LoanApplication> findRejectedApplications() {
        return loanApplicationService.findRejectedApplications();
    }

    @GetMapping("/amount-greater-than/{amount}")
    public List<LoanApplication> findByLoanAmountGreaterThan(@PathVariable double amount) {
        return loanApplicationService.findByLoanAmountGreaterThan(amount);
    }

    @GetMapping("/amount-less-than/{amount}")
    public List<LoanApplication> findByLoanAmountLessThan(@PathVariable double amount) {
        return loanApplicationService.findByLoanAmountLessThan(amount);
    }

    @GetMapping("/amount-between/{minAmount}/{maxAmount}")
    public List<LoanApplication> findByLoanAmountBetween(@PathVariable double minAmount, @PathVariable double maxAmount) {
        return loanApplicationService.findByLoanAmountBetween(minAmount, maxAmount);
    }

    @GetMapping("/status/{status}")
    public List<LoanApplication> findByStatus(@PathVariable String status) {
        return loanApplicationService.findByStatus(status);
    }

    @GetMapping("/customer/{customerId}/status/{status}")
    public List<LoanApplication> findByCustomerIdAndStatus(@PathVariable Long customerId, @PathVariable String status) {
        return loanApplicationService.findByCustomerIdAndStatus(customerId, status);
    }

    @GetMapping("/customer/{customerId}/amount-greater-than/{amount}")
    public List<LoanApplication> findByCustomerIdAndLoanAmountGreaterThan(@PathVariable Long customerId, @PathVariable double amount) {
        return loanApplicationService.findByCustomerIdAndLoanAmountGreaterThan(customerId, amount);
    }

    @GetMapping("/customer/{customerId}/amount-less-than/{amount}")
    public List<LoanApplication> findByCustomerIdAndLoanAmountLessThan(@PathVariable Long customerId, @PathVariable double amount) {
        return loanApplicationService.findByCustomerIdAndLoanAmountLessThan(customerId, amount);
    }

    @GetMapping("/customer/{customerId}/amount-between/{minAmount}/{maxAmount}")
    public List<LoanApplication> findByCustomerIdAndLoanAmountBetween(@PathVariable Long customerId, @PathVariable double minAmount, @PathVariable double maxAmount) {
        return loanApplicationService.findByCustomerIdAndLoanAmountBetween(customerId, minAmount, maxAmount);
    }

    // Other required methods and their implementations

    // Add your business methods here

}