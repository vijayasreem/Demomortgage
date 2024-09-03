package com.sacral.java.service;

import com.sacral.java.model.FFApprovalRequest;
import com.sacral.java.repository.FFApprovalRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FFApprovalRequestService {

    private final FFApprovalRequestRepository ffApprovalRequestRepository;

    @Autowired
    public FFApprovalRequestService(FFApprovalRequestRepository ffApprovalRequestRepository) {
        this.ffApprovalRequestRepository = ffApprovalRequestRepository;
    }

    public List<FFApprovalRequest> findPendingRequests() {
        return ffApprovalRequestRepository.findPendingRequests();
    }

    public FFApprovalRequest findPendingRequestById(Long id) {
        return ffApprovalRequestRepository.findPendingRequestById(id);
    }

    public List<FFApprovalRequest> searchPendingRequestsByRemarks(String keyword) {
        return ffApprovalRequestRepository.searchPendingRequestsByRemarks(keyword);
    }

    public List<FFApprovalRequest> searchPendingRequestsByRemarksAndCreatedBy(String keyword, String createdBy) {
        return ffApprovalRequestRepository.searchPendingRequestsByRemarksAndCreatedBy(keyword, createdBy);
    }

    // Add more business methods as needed

}