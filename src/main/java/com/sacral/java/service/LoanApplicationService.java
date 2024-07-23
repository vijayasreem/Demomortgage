package com.sacral.java.service;

import com.sacral.java.model.LoanApplication;
import com.sacral.java.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanApplicationService {

    private final LoanApplicationRepository loanApplicationRepository;

    @Autowired
    public LoanApplicationService(LoanApplicationRepository loanApplicationRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
    }

    public List<LoanApplication> findPendingApplications() {
        return loanApplicationRepository.findPendingApplications();
    }

    public List<LoanApplication> findApprovedApplications() {
        return loanApplicationRepository.findApprovedApplications();
    }

    public List<LoanApplication> findRejectedApplications() {
        return loanApplicationRepository.findRejectedApplications();
    }

    public List<LoanApplication> findApplicationsByCustomerId(Long customerId) {
        return loanApplicationRepository.findApplicationsByCustomerId(customerId);
    }

    public List<LoanApplication> findApplicationsByVehicleMake(String make) {
        return loanApplicationRepository.findApplicationsByVehicleMake(make);
    }

    public List<LoanApplication> findApplicationsByVehicleModel(String model) {
        return loanApplicationRepository.findApplicationsByVehicleModel(model);
    }

    public List<LoanApplication> findApplicationsByVehicleYear(int year) {
        return loanApplicationRepository.findApplicationsByVehicleYear(year);
    }

    // Add more business methods as needed

}