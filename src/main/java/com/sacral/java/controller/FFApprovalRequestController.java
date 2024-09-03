package com.sacral.java.controller;

import com.sacral.java.model.FFApprovalRequest;
import com.sacral.java.service.FFApprovalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ff-approval")
public class FFApprovalRequestController {

    private final FFApprovalRequestService ffApprovalRequestService;

    @Autowired
    public FFApprovalRequestController(FFApprovalRequestService ffApprovalRequestService) {
        this.ffApprovalRequestService = ffApprovalRequestService;
    }

    @GetMapping("/pending-requests")
    public List<FFApprovalRequest> findPendingRequests() {
        return ffApprovalRequestService.findPendingRequests();
    }

    @GetMapping("/pending-request/{id}")
    public FFApprovalRequest findPendingRequestById(@PathVariable Long id) {
        return ffApprovalRequestService.findPendingRequestById(id);
    }

    @GetMapping("/pending-requests/search")
    public List<FFApprovalRequest> searchPendingRequestsByRemarks(@RequestParam String keyword) {
        return ffApprovalRequestService.searchPendingRequestsByRemarks(keyword);
    }

    @GetMapping("/pending-requests/search-by-remarks-and-created-by")
    public List<FFApprovalRequest> searchPendingRequestsByRemarksAndCreatedBy(@RequestParam String keyword, @RequestParam String createdBy) {
        return ffApprovalRequestService.searchPendingRequestsByRemarksAndCreatedBy(keyword, createdBy);
    }

    // Add more business methods as needed

}