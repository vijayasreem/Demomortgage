package com.sacral.java.controller;

import com.sacral.java.model.LoanApplication;
import com.sacral.java.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public List<LoanApplication> findByCustomerId(@PathVariable Long customerId) {
        return loanApplicationService.findByCustomerId(customerId);
    }

    @GetMapping("/status/{status}")
    public List<LoanApplication> findByStatus(@PathVariable String status) {
        return loanApplicationService.findByStatus(status);
    }

    @GetMapping("/loan-amount-range")
    public List<LoanApplication> findByLoanAmountRange(@RequestParam("minAmount") Double minAmount, @RequestParam("maxAmount") Double maxAmount) {
        return loanApplicationService.findByLoanAmountRange(minAmount, maxAmount);
    }

    @GetMapping("/{applicationId}")
    public LoanApplication findByApplicationId(@PathVariable Long applicationId) {
        return loanApplicationService.findByApplicationId(applicationId);
    }

    @GetMapping("/application-number/{applicationNumber}")
    public LoanApplication findByApplicationNumber(@PathVariable String applicationNumber) {
        return loanApplicationService.findByApplicationNumber(applicationNumber);
    }

    @GetMapping("/customer-name/{customerName}")
    public List<LoanApplication> findByCustomerName(@PathVariable String customerName) {
        return loanApplicationService.findByCustomerName(customerName);
    }

    @GetMapping("/customer-email/{customerEmail}")
    public List<LoanApplication> findByCustomerEmail(@PathVariable String customerEmail) {
        return loanApplicationService.findByCustomerEmail(customerEmail);
    }

    @GetMapping("/customer-phone/{customerPhone}")
    public List<LoanApplication> findByCustomerPhone(@PathVariable String customerPhone) {
        return loanApplicationService.findByCustomerPhone(customerPhone);
    }

    @GetMapping("/employment-details/{employmentDetails}")
    public List<LoanApplication> findByEmploymentDetails(@PathVariable String employmentDetails) {
        return loanApplicationService.findByEmploymentDetails(employmentDetails);
    }

    @GetMapping("/loan-type/{loanType}")
    public List<LoanApplication> findByLoanType(@PathVariable String loanType) {
        return loanApplicationService.findByLoanType(loanType);
    }

    @GetMapping("/loan-term/{loanTerm}")
    public List<LoanApplication> findByLoanTerm(@PathVariable Integer loanTerm) {
        return loanApplicationService.findByLoanTerm(loanTerm);
    }

    @GetMapping("/loan-status/{loanStatus}")
    public List<LoanApplication> findByLoanStatus(@PathVariable String loanStatus) {
        return loanApplicationService.findByLoanStatus(loanStatus);
    }

    @GetMapping("/approval-status/{approvalStatus}")
    public List<LoanApplication> findByApprovalStatus(@PathVariable String approvalStatus) {
        return loanApplicationService.findByApprovalStatus(approvalStatus);
    }

    @GetMapping("/rejection-reason/{rejectionReason}")
    public List<LoanApplication> findByRejectionReason(@PathVariable String rejectionReason) {
        return loanApplicationService.findByRejectionReason(rejectionReason);
    }

    @GetMapping("/submitted-date/{submittedDate}")
    public List<LoanApplication> findBySubmittedDate(@PathVariable Date submittedDate) {
        return loanApplicationService.findBySubmittedDate(submittedDate);
    }

    @GetMapping("/approved-date/{approvedDate}")
    public List<LoanApplication> findByApprovedDate(@PathVariable Date approvedDate) {
        return loanApplicationService.findByApprovedDate(approvedDate);
    }

    @GetMapping("/rejected-date/{rejectedDate}")
    public List<LoanApplication> findByRejectedDate(@PathVariable Date rejectedDate) {
        return loanApplicationService.findByRejectedDate(rejectedDate);
    }

    @GetMapping("/closed-date/{closedDate}")
    public List<LoanApplication> findByClosedDate(@PathVariable Date closedDate) {
        return loanApplicationService.findByClosedDate(closedDate);
    }

    @GetMapping("/last-modified-date/{lastModifiedDate}")
    public List<LoanApplication> findByLastModifiedDate(@PathVariable Date lastModifiedDate) {
        return loanApplicationService.findByLastModifiedDate(lastModifiedDate);
    }
}