
package com.sacral.java.repository;

import com.sacral.java.model.DocumentVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentVerificationRepository extends JpaRepository<DocumentVerification, Long> {

    @Query("SELECT dv FROM DocumentVerification dv WHERE dv.identityVerified = true AND dv.addressVerified = true")
    DocumentVerification findVerifiedDocument();

    @Query("SELECT dv FROM DocumentVerification dv WHERE dv.identityVerified = false OR dv.addressVerified = false")
    DocumentVerification findIncompleteDocument();

    @Query("SELECT dv FROM DocumentVerification dv WHERE dv.annualIncome >= 30000 AND dv.creditScore >= 700")
    DocumentVerification findHighLimitEligible();

    @Query("SELECT dv FROM DocumentVerification dv WHERE dv.annualIncome >= 20000 AND dv.creditScore >= 600")
    DocumentVerification findModerateLimitEligible();
}
