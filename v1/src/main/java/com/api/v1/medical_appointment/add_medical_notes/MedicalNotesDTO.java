package com.api.v1.medical_appointment.add_medical_notes;

import java.time.LocalDateTime;

import com.api.v1.helper.PhysicianLicenseNumber;
import com.api.v1.helper.SSN;

import jakarta.validation.constraints.NotBlank;

public record MedicalNotesDTO(
    @SSN String ssn, 
    @PhysicianLicenseNumber String physicianLicenseNumber, 
    LocalDateTime dateTime,
    @NotBlank
    String notes
) {
} 