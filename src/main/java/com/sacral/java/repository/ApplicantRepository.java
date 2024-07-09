
package com.sacral.java.repository;

import com.sacral.java.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

    @Query("SELECT a.creditScore FROM Applicant a WHERE a.id = :applicantId")
    int getCreditScoreById(Long applicantId);

    @Query("SELECT a.loanAmount FROM Applicant a WHERE a.id = :applicantId")
    double getLoanAmountById(Long applicantId);

    @Query("SELECT a.interestRate FROM Applicant a WHERE a.id = :applicantId")
    double getInterestRateById(Long applicantId);

    // Add more custom queries as needed

}
