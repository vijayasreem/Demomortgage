
package com.sacral.java.repository;

import com.sacral.java.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

    @Query("SELECT la FROM LoanApplication la WHERE la.status = 'PENDING'")
    List<LoanApplication> findPendingApplications();

    @Query("SELECT la FROM LoanApplication la WHERE la.status = 'APPROVED'")
    List<LoanApplication> findApprovedApplications();

    @Query("SELECT la FROM LoanApplication la WHERE la.status = 'REJECTED'")
    List<LoanApplication> findRejectedApplications();

    @Query("SELECT la FROM LoanApplication la WHERE la.customerId = :customerId")
    List<LoanApplication> findApplicationsByCustomerId(Long customerId);

    @Query("SELECT la FROM LoanApplication la WHERE la.vehicleMake = :make")
    List<LoanApplication> findApplicationsByVehicleMake(String make);

    @Query("SELECT la FROM LoanApplication la WHERE la.vehicleModel = :model")
    List<LoanApplication> findApplicationsByVehicleModel(String model);

    @Query("SELECT la FROM LoanApplication la WHERE la.vehicleYear = :year")
    List<LoanApplication> findApplicationsByVehicleYear(int year);

    // Add more custom queries as needed

}
