package com.api.v1.medical_appointment.add_medical_notes;

import org.springframework.format.annotation.DateTimeFormat;

import com.api.v1.auxiliary.PhysicianLicenseNumber;
import com.api.v1.auxiliary.SSN;

import jakarta.validation.constraints.NotBlank;

public record MedicalNotesDTO(
    @SSN String ssn, 
    @PhysicianLicenseNumber String physicianLicenseNumber, 
    @DateTimeFormat String dateTime,
    @NotBlank
    String notes
) {
} 