
package com.sacral.java.repository;

import com.sacral.java.model.DisbursementTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DisbursementTransactionRepository extends JpaRepository<DisbursementTransaction, Long> {

    @Query("SELECT dt FROM DisbursementTransaction dt WHERE dt.disbursedAmount <= dt.vehicleAssessmentValue")
    List<DisbursementTransaction> findValidDisbursements();

    @Query("SELECT dt FROM DisbursementTransaction dt WHERE dt.disbursedAmount > dt.vehicleAssessmentValue")
    List<DisbursementTransaction> findInvalidDisbursements();

    @Query("SELECT dt FROM DisbursementTransaction dt WHERE dt.paymentAmount <= 1000.0")
    List<DisbursementTransaction> findAutomaticallyApprovedPayments();

    @Query("SELECT dt FROM DisbursementTransaction dt WHERE dt.paymentApprovalRequired = true AND dt.paymentApproved = false")
    List<DisbursementTransaction> findPaymentsRequiringApproval();

    @Query("SELECT dt FROM DisbursementTransaction dt WHERE dt.vendorInformationVerified = true AND dt.fundsAvailabilityConfirmed = true AND dt.paymentApproved = true")
    List<DisbursementTransaction> findSuccessfulDisbursements();

    @Query("SELECT dt FROM DisbursementTransaction dt WHERE dt.vendorInformationVerified = false")
    List<DisbursementTransaction> findInvalidVendorInformation();

    @Query("SELECT dt FROM DisbursementTransaction dt WHERE dt.fundsAvailabilityConfirmed = false")
    List<DisbursementTransaction> findInsufficientFundsDisbursements();

    // Additional methods for logging, notifications, and monitoring can be added here

}
