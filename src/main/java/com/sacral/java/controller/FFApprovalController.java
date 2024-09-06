
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FFApprovalController {

    @Autowired
    private JavaMailSender mailSender;

    private Map<String, Map<String, String>> cases = new HashMap<>();

    @GetMapping("/ff_approval_request_form")
    public String getFFApprovalRequestForm() {
        return "<form action=\"/submit_ff_approval_request\" method=\"post\">" +
                "Case ID: <input type=\"text\" name=\"case_id\"><br>" +
                "Case Remarks: <textarea name=\"case_remarks\"></textarea><br>" +
                "<input type=\"submit\" value=\"Submit\">" +
                "</form>";
    }

    @PostMapping("/submit_ff_approval_request")
    public String submitFFApprovalRequest(@RequestParam String case_id, @RequestParam String case_remarks) {
        Map<String, String> caseDetails = new HashMap<>();
        caseDetails.put("status", "F&F Approval Pending with QC2");
        caseDetails.put("remarks", case_remarks);
        cases.put(case_id, caseDetails);
        sendEmail(case_id, case_remarks);
        return "F&F approval request submitted.";
    }

    private void sendEmail(String case_id, String case_remarks) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("qc2@example.com");
        message.setSubject("F&F Approval Request");
        message.setText("Case ID: " + case_id + "\nRemarks: " + case_remarks);
        message.setFrom("your-email@example.com");
        mailSender.send(message);
    }

    @PostMapping("/review_ff_approval_request/{case_id}")
    public String reviewFFApprovalRequest(@PathVariable String case_id, @RequestParam String decision, @RequestParam String qc2_remarks) {
        Map<String, String> caseDetails = cases.get(case_id);
        caseDetails.put("status", decision.equals("approve") ? "Approved" : "Rejected");
        caseDetails.put("qc2_remarks", qc2_remarks);
        return "F&F approval request reviewed.";
    }
}
