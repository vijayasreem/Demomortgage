package com.sacral.java.service;

import com.sacral.java.model.LoanApplication;
import com.sacral.java.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanApplicationService {

    private final LoanApplicationRepository loanApplicationRepository;

    @Autowired
    public LoanApplicationService(LoanApplicationRepository loanApplicationRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
    }

    // Custom queries for loan application

    public LoanApplication findByCustomerId(Long customerId) {
        return loanApplicationRepository.findByCustomerId(customerId);
    }

    public List<LoanApplication> findPendingApplications() {
        return loanApplicationRepository.findPendingApplications();
    }

    public List<LoanApplication> findApprovedApplications() {
        return loanApplicationRepository.findApprovedApplications();
    }

    public List<LoanApplication> findRejectedApplications() {
        return loanApplicationRepository.findRejectedApplications();
    }

    // Other required methods

    public List<LoanApplication> findByLoanAmountGreaterThan(double amount) {
        return loanApplicationRepository.findByLoanAmountGreaterThan(amount);
    }

    public List<LoanApplication> findByLoanAmountLessThan(double amount) {
        return loanApplicationRepository.findByLoanAmountLessThan(amount);
    }

    public List<LoanApplication> findByLoanAmountBetween(double minAmount, double maxAmount) {
        return loanApplicationRepository.findByLoanAmountBetween(minAmount, maxAmount);
    }

    public List<LoanApplication> findByStatus(String status) {
        return loanApplicationRepository.findByStatus(status);
    }

    public List<LoanApplication> findByCustomerIdAndStatus(Long customerId, String status) {
        return loanApplicationRepository.findByCustomerIdAndStatus(customerId, status);
    }

    public List<LoanApplication> findByCustomerIdAndLoanAmountGreaterThan(Long customerId, double amount) {
        return loanApplicationRepository.findByCustomerIdAndLoanAmountGreaterThan(customerId, amount);
    }

    public List<LoanApplication> findByCustomerIdAndLoanAmountLessThan(Long customerId, double amount) {
        return loanApplicationRepository.findByCustomerIdAndLoanAmountLessThan(customerId, amount);
    }

    public List<LoanApplication> findByCustomerIdAndLoanAmountBetween(Long customerId, double minAmount, double maxAmount) {
        return loanApplicationRepository.findByCustomerIdAndLoanAmountBetween(customerId, minAmount, maxAmount);
    }
}