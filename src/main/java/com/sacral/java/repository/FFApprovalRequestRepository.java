
package com.sacral.java.repository;

import com.sacral.java.entity.FFApprovalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FFApprovalRequestRepository extends JpaRepository<FFApprovalRequest, Long> {

    @Query("SELECT r FROM FFApprovalRequest r WHERE r.status = 'F&F Approval Pending with QC2'")
    List<FFApprovalRequest> findPendingRequests();

    @Query("UPDATE FFApprovalRequest r SET r.status = :status WHERE r.id = :id")
    void updateStatus(@Param("id") Long id, @Param("status") String status);

    @Query("SELECT r FROM FFApprovalRequest r WHERE r.qc2ManagerId = :managerId")
    List<FFApprovalRequest> findRequestsByManager(@Param("managerId") Long managerId);

    @Query("UPDATE FFApprovalRequest r SET r.qc2Remarks = :remarks, r.status = :status WHERE r.id = :id")
    void updateRemarksAndStatus(@Param("id") Long id, @Param("remarks") String remarks, @Param("status") String status);
}
