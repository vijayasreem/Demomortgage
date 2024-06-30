
package com.sacral.java.repository;

import com.sacral.java.model.CreditEligibility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditEligibilityRepository extends JpaRepository<CreditEligibility, Long> {

    @Query("SELECT ce FROM CreditEligibility ce WHERE ce.annualIncome >= 30000 AND ce.creditScore >= 700")
    CreditEligibility findHighLimitEligibility();

    @Query("SELECT ce FROM CreditEligibility ce WHERE ce.annualIncome >= 20000 AND ce.creditScore >= 600")
    CreditEligibility findModerateLimitEligibility();
}
