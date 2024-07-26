
package com.sacral.java.repository;

import com.sacral.java.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

    // Custom queries for loan application

    @Query("SELECT la FROM LoanApplication la WHERE la.customerId = :customerId")
    List<LoanApplication> findByCustomerId(Long customerId);

    @Query("SELECT la FROM LoanApplication la WHERE la.status = :status")
    List<LoanApplication> findByStatus(String status);

    @Query("SELECT la FROM LoanApplication la WHERE la.loanAmount >= :minAmount AND la.loanAmount <= :maxAmount")
    List<LoanApplication> findByLoanAmountRange(Double minAmount, Double maxAmount);

    // Other required methods

    LoanApplication findByApplicationId(Long applicationId);

    LoanApplication findByApplicationNumber(String applicationNumber);

    List<LoanApplication> findByCustomerName(String customerName);

    List<LoanApplication> findByCustomerEmail(String customerEmail);

    List<LoanApplication> findByCustomerPhone(String customerPhone);

    List<LoanApplication> findByEmploymentDetails(String employmentDetails);

    List<LoanApplication> findByLoanType(String loanType);

    List<LoanApplication> findByLoanTerm(Integer loanTerm);

    List<LoanApplication> findByLoanStatus(String loanStatus);

    List<LoanApplication> findByApprovalStatus(String approvalStatus);

    List<LoanApplication> findByRejectionReason(String rejectionReason);

    List<LoanApplication> findBySubmittedDate(Date submittedDate);

    List<LoanApplication> findByApprovedDate(Date approvedDate);

    List<LoanApplication> findByRejectedDate(Date rejectedDate);

    List<LoanApplication> findByClosedDate(Date closedDate);

    List<LoanApplication> findByLastModifiedDate(Date lastModifiedDate);

}
