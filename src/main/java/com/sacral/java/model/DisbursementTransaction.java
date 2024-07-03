
package com.sacral.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DisbursementTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Double disbursedAmount;
    private Double vehicleAssessmentValue;
    private Double paymentAmount;
    private Boolean paymentApprovalRequired;
    private Boolean paymentApproved;
    private Boolean vendorInformationVerified;
    private Boolean fundsAvailabilityConfirmed;
    
    // Getters and Setters
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Double getDisbursedAmount() {
        return disbursedAmount;
    }
    
    public void setDisbursedAmount(Double disbursedAmount) {
        this.disbursedAmount = disbursedAmount;
    }
    
    public Double getVehicleAssessmentValue() {
        return vehicleAssessmentValue;
    }
    
    public void setVehicleAssessmentValue(Double vehicleAssessmentValue) {
        this.vehicleAssessmentValue = vehicleAssessmentValue;
    }
    
    public Double getPaymentAmount() {
        return paymentAmount;
    }
    
    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    
    public Boolean getPaymentApprovalRequired() {
        return paymentApprovalRequired;
    }
    
    public void setPaymentApprovalRequired(Boolean paymentApprovalRequired) {
        this.paymentApprovalRequired = paymentApprovalRequired;
    }
    
    public Boolean getPaymentApproved() {
        return paymentApproved;
    }
    
    public void setPaymentApproved(Boolean paymentApproved) {
        this.paymentApproved = paymentApproved;
    }
    
    public Boolean getVendorInformationVerified() {
        return vendorInformationVerified;
    }
    
    public void setVendorInformationVerified(Boolean vendorInformationVerified) {
        this.vendorInformationVerified = vendorInformationVerified;
    }
    
    public Boolean getFundsAvailabilityConfirmed() {
        return fundsAvailabilityConfirmed;
    }
    
    public void setFundsAvailabilityConfirmed(Boolean fundsAvailabilityConfirmed) {
        this.fundsAvailabilityConfirmed = fundsAvailabilityConfirmed;
    }
}
