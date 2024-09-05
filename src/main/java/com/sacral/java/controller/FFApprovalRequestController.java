
package com.sacral.java.controller;

import com.sacral.java.entity.FFApprovalRequest;
import com.sacral.java.service.FFApprovalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ff-approval")
public class FFApprovalRequestController {

    @Autowired
    private FFApprovalRequestService service;

    @GetMapping("/pending")
    public List<FFApprovalRequest> getPendingRequests() {
        return service.getPendingRequests();
    }

    @PostMapping("/submit")
    public void submitApprovalRequest(@RequestBody FFApprovalRequest request) {
        service.submitApprovalRequest(request);
    }

    @PutMapping("/update-status/{id}")
    public void updateStatus(@PathVariable Long id, @RequestParam String status) {
        service.updateStatus(id, status);
    }

    @GetMapping("/manager/{managerId}")
    public List<FFApprovalRequest> getRequestsByManager(@PathVariable Long managerId) {
        return service.getRequestsByManager(managerId);
    }

    @PutMapping("/update-remarks-status/{id}")
    public void updateRemarksAndStatus(@PathVariable Long id, @RequestParam String remarks, @RequestParam String status) {
        service.updateRemarksAndStatus(id, remarks, status);
    }

    @PutMapping("/review/{id}")
    public void reviewRequest(@PathVariable Long id, @RequestParam String remarks, @RequestParam String status) {
        service.reviewRequest(id, remarks, status);
    }
}
