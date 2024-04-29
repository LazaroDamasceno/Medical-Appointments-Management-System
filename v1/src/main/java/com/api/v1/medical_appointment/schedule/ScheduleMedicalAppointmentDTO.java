package com.api.v1.medical_appointment.schedule;

import com.api.v1.helper.DateTimeFormat;
import com.api.v1.helper.PhysicianLicenseNumber;
import com.api.v1.helper.SSN;

import jakarta.validation.constraints.Future;

public record ScheduleMedicalAppointmentDTO(
    @SSN String ssn, 
    @PhysicianLicenseNumber String physicianLicenseNumber, 
    @DateTimeFormat @Future String dateTime
) {
    
}
