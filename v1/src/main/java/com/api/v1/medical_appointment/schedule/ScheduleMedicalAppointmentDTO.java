package com.api.v1.medical_appointment.schedule;

import com.api.v1.auxiliary.customized_annotations.DateTimeFormat;
import com.api.v1.auxiliary.customized_annotations.PhysicianLicenseNumber;
import com.api.v1.auxiliary.customized_annotations.SSN;

import jakarta.validation.constraints.Future;

public record ScheduleMedicalAppointmentDTO(
    @SSN String ssn, 
    @PhysicianLicenseNumber String physicianLicenseNumber, 
    @DateTimeFormat @Future String dateTime
) {
    
}
