
package com.sacral.java.service;

import com.sacral.java.entity.FFApprovalRequest;
import com.sacral.java.repository.FFApprovalRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FFApprovalRequestService {

    @Autowired
    private FFApprovalRequestRepository repository;

    public List<FFApprovalRequest> getPendingRequests() {
        return repository.findPendingRequests();
    }

    public void updateStatus(Long id, String status) {
        repository.updateStatus(id, status);
    }

    public List<FFApprovalRequest> getRequestsByManager(Long managerId) {
        return repository.findRequestsByManager(managerId);
    }

    public void updateRemarksAndStatus(Long id, String remarks, String status) {
        repository.updateRemarksAndStatus(id, remarks, status);
    }

    public void submitApprovalRequest(FFApprovalRequest request) {
        request.setStatus("F&F Approval Pending with QC2");
        repository.save(request);
        sendAutoMailer(request);
    }

    private void sendAutoMailer(FFApprovalRequest request) {
        // Logic to send an email notification
    }

    public void reviewRequest(Long id, String remarks, String status) {
        updateRemarksAndStatus(id, remarks, status);
    }
}
