
package com.sacral.java.model;

import javax.persistence.*;

@Entity
@Table(name = "ff_approval_request")
public class FFApprovalRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "qc2_manager_id")
    private Long qc2ManagerId;

    @Column(name = "qc2_remarks")
    private String qc2Remarks;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getQc2ManagerId() {
        return qc2ManagerId;
    }

    public void setQc2ManagerId(Long qc2ManagerId) {
        this.qc2ManagerId = qc2ManagerId;
    }

    public String getQc2Remarks() {
        return qc2Remarks;
    }

    public void setQc2Remarks(String qc2Remarks) {
        this.qc2Remarks = qc2Remarks;
    }
}
