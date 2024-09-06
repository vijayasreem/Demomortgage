
package com.example.ffapprovalservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/ff_approval")
public class FFApprovalService {

    @Autowired
    private JavaMailSender mailSender;

    private final Map<Integer, Case> cases = new HashMap<>();
    private final AtomicInteger caseIdCounter = new AtomicInteger(1);

    @GetMapping("/request_form")
    public String getFFApprovalRequestForm() {
        return "<form action=\"/ff_approval/submit_request\" method=\"post\">" +
                "Case Remarks: <input type=\"text\" name=\"case_remarks\"><br>" +
                "<input type=\"submit\" value=\"Submit\">" +
                "</form>";
    }

    @PostMapping("/submit_request")
    public Map<String, Object> submitFFApprovalRequest(@RequestParam String case_remarks) {
        int caseId = caseIdCounter.getAndIncrement();
        cases.put(caseId, new Case(case_remarks, "F&F Approval Pending with QC2", null));
        sendEmail(caseId, case_remarks);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Request submitted successfully");
        response.put("case_id", caseId);
        return response;
    }

    @PostMapping("/review_request/{caseId}")
    public Map<String, Object> reviewFFApprovalRequest(@PathVariable int caseId, @RequestParam String decision, @RequestParam String remarks) {
        Map<String, Object> response = new HashMap<>();
        Case caseDetails = cases.get(caseId);
        if (caseDetails != null) {
            caseDetails.setDecision(decision);
            caseDetails.setRemarks(remarks);
            caseDetails.setStatus("Approved".equalsIgnoreCase(decision) ? "Approved" : "Rejected");
            response.put("message", "Decision recorded successfully");
        } else {
            response.put("message", "Case not found");
            response.put("status", 404);
        }
        return response;
    }

    private void sendEmail(int caseId, String caseRemarks) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("qc2@example.com");
        message.setSubject("F&F Approval Request");
        message.setText("Case ID: " + caseId + "\nRemarks: " + caseRemarks);
        mailSender.send(message);
    }

    private static class Case {
        private String remarks;
        private String status;
        private String decision;

        public Case(String remarks, String status, String decision) {
            this.remarks = remarks;
            this.status = status;
            this.decision = decision;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setDecision(String decision) {
            this.decision = decision;
        }
    }
}
