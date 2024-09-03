
package com.sacral.java.repository;

import com.sacral.java.model.FFApprovalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FFApprovalRequestRepository extends JpaRepository<FFApprovalRequest, Long> {

    @Query("SELECT f FROM FFApprovalRequest f WHERE f.status = 'F&F Approval Pending with QC2'")
    List<FFApprovalRequest> findPendingRequests();

    @Query("SELECT f FROM FFApprovalRequest f WHERE f.status = 'F&F Approval Pending with QC2' AND f.id = :id")
    FFApprovalRequest findPendingRequestById(Long id);

    @Query("SELECT f FROM FFApprovalRequest f WHERE f.status = 'F&F Approval Pending with QC2' AND f.remarks LIKE %:keyword%")
    List<FFApprovalRequest> searchPendingRequestsByRemarks(String keyword);

    @Query("SELECT f FROM FFApprovalRequest f WHERE f.status = 'F&F Approval Pending with QC2' AND f.remarks LIKE %:keyword% AND f.createdBy = :createdBy")
    List<FFApprovalRequest> searchPendingRequestsByRemarksAndCreatedBy(String keyword, String createdBy);

    // Add more custom queries as needed

}
