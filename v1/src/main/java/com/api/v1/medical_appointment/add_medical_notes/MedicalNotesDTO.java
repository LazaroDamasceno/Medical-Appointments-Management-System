package com.api.v1.medical_appointment.add_medical_notes;

import java.time.LocalDateTime;

import com.api.v1.helpers.PhysicianLicenseNumber;
import com.api.v1.helpers.SSN;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicalNotesDTO(
    @SSN String ssn, 
    @PhysicianLicenseNumber String physicianLicenseNumber, 
    @NotNull LocalDateTime dateTime,
    @NotBlank String notes
) {
} 