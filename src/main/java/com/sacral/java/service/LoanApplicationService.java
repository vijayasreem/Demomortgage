package com.sacral.java.service;

import com.sacral.java.model.LoanApplication;
import com.sacral.java.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoanApplicationService {

    private final LoanApplicationRepository loanApplicationRepository;

    @Autowired
    public LoanApplicationService(LoanApplicationRepository loanApplicationRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
    }

    // Custom queries for loan application

    public List<LoanApplication> findByCustomerId(Long customerId) {
        return loanApplicationRepository.findByCustomerId(customerId);
    }

    public List<LoanApplication> findByStatus(String status) {
        return loanApplicationRepository.findByStatus(status);
    }

    public List<LoanApplication> findByLoanAmountRange(Double minAmount, Double maxAmount) {
        return loanApplicationRepository.findByLoanAmountRange(minAmount, maxAmount);
    }

    // Other required methods

    public LoanApplication findByApplicationId(Long applicationId) {
        return loanApplicationRepository.findByApplicationId(applicationId);
    }

    public LoanApplication findByApplicationNumber(String applicationNumber) {
        return loanApplicationRepository.findByApplicationNumber(applicationNumber);
    }

    public List<LoanApplication> findByCustomerName(String customerName) {
        return loanApplicationRepository.findByCustomerName(customerName);
    }

    public List<LoanApplication> findByCustomerEmail(String customerEmail) {
        return loanApplicationRepository.findByCustomerEmail(customerEmail);
    }

    public List<LoanApplication> findByCustomerPhone(String customerPhone) {
        return loanApplicationRepository.findByCustomerPhone(customerPhone);
    }

    public List<LoanApplication> findByEmploymentDetails(String employmentDetails) {
        return loanApplicationRepository.findByEmploymentDetails(employmentDetails);
    }

    public List<LoanApplication> findByLoanType(String loanType) {
        return loanApplicationRepository.findByLoanType(loanType);
    }

    public List<LoanApplication> findByLoanTerm(Integer loanTerm) {
        return loanApplicationRepository.findByLoanTerm(loanTerm);
    }

    public List<LoanApplication> findByLoanStatus(String loanStatus) {
        return loanApplicationRepository.findByLoanStatus(loanStatus);
    }

    public List<LoanApplication> findByApprovalStatus(String approvalStatus) {
        return loanApplicationRepository.findByApprovalStatus(approvalStatus);
    }

    public List<LoanApplication> findByRejectionReason(String rejectionReason) {
        return loanApplicationRepository.findByRejectionReason(rejectionReason);
    }

    public List<LoanApplication> findBySubmittedDate(Date submittedDate) {
        return loanApplicationRepository.findBySubmittedDate(submittedDate);
    }

    public List<LoanApplication> findByApprovedDate(Date approvedDate) {
        return loanApplicationRepository.findByApprovedDate(approvedDate);
    }

    public List<LoanApplication> findByRejectedDate(Date rejectedDate) {
        return loanApplicationRepository.findByRejectedDate(rejectedDate);
    }

    public List<LoanApplication> findByClosedDate(Date closedDate) {
        return loanApplicationRepository.findByClosedDate(closedDate);
    }

    public List<LoanApplication> findByLastModifiedDate(Date lastModifiedDate) {
        return loanApplicationRepository.findByLastModifiedDate(lastModifiedDate);
    }
}