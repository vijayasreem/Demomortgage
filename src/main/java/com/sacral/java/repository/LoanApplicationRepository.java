
package com.sacral.java.repository;

import com.sacral.java.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

    // Custom queries for loan application

    @Query("SELECT la FROM LoanApplication la WHERE la.customerId = ?1")
    LoanApplication findByCustomerId(Long customerId);

    @Query("SELECT la FROM LoanApplication la WHERE la.status = 'PENDING'")
    List<LoanApplication> findPendingApplications();

    @Query("SELECT la FROM LoanApplication la WHERE la.status = 'APPROVED'")
    List<LoanApplication> findApprovedApplications();

    @Query("SELECT la FROM LoanApplication la WHERE la.status = 'REJECTED'")
    List<LoanApplication> findRejectedApplications();

    // Other required methods

    List<LoanApplication> findByLoanAmountGreaterThan(double amount);

    List<LoanApplication> findByLoanAmountLessThan(double amount);

    List<LoanApplication> findByLoanAmountBetween(double minAmount, double maxAmount);

    List<LoanApplication> findByStatus(String status);

    List<LoanApplication> findByCustomerIdAndStatus(Long customerId, String status);

    List<LoanApplication> findByCustomerIdAndLoanAmountGreaterThan(Long customerId, double amount);

    List<LoanApplication> findByCustomerIdAndLoanAmountLessThan(Long customerId, double amount);

    List<LoanApplication> findByCustomerIdAndLoanAmountBetween(Long customerId, double minAmount, double maxAmount);

}
