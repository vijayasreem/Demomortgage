package com.sacral.java.controller;

import com.sacral.java.model.LoanApplication;
import com.sacral.java.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan-applications")
public class LoanApplicationController {

    private final LoanApplicationService loanApplicationService;

    @Autowired
    public LoanApplicationController(LoanApplicationService loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }

    @GetMapping("/pending")
    public List<LoanApplication> findPendingApplications() {
        return loanApplicationService.findPendingApplications();
    }

    @GetMapping("/approved")
    public List<LoanApplication> findApprovedApplications() {
        return loanApplicationService.findApprovedApplications();
    }

    @GetMapping("/rejected")
    public List<LoanApplication> findRejectedApplications() {
        return loanApplicationService.findRejectedApplications();
    }

    @GetMapping("/customer/{customerId}")
    public List<LoanApplication> findApplicationsByCustomerId(@PathVariable Long customerId) {
        return loanApplicationService.findApplicationsByCustomerId(customerId);
    }

    @GetMapping("/vehicle/make/{make}")
    public List<LoanApplication> findApplicationsByVehicleMake(@PathVariable String make) {
        return loanApplicationService.findApplicationsByVehicleMake(make);
    }

    @GetMapping("/vehicle/model/{model}")
    public List<LoanApplication> findApplicationsByVehicleModel(@PathVariable String model) {
        return loanApplicationService.findApplicationsByVehicleModel(model);
    }

    @GetMapping("/vehicle/year/{year}")
    public List<LoanApplication> findApplicationsByVehicleYear(@PathVariable int year) {
        return loanApplicationService.findApplicationsByVehicleYear(year);
    }

    // Add more business methods as needed

}