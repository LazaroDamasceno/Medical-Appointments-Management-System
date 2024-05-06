package com.api.v1.medical_appointment.schedule;

import java.time.LocalDateTime;

import com.api.v1.helper.PhysicianLicenseNumber;
import com.api.v1.helper.SSN;

import jakarta.validation.constraints.Future;

public record ScheduleMedicalAppointmentDTO(
    @SSN String ssn, 
    @PhysicianLicenseNumber String physicianLicenseNumber, 
    @Future LocalDateTime dateTime
) {
    
}
