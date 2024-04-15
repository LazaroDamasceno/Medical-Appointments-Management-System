package com.api.v1.medical_appointment.find_by_patient;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record FindMedicalAppointmentsDTO2(
    @NotBlank
    @Size(min=9, max=9)
    String ssn,

    @NotBlank
    @Size(min=7, max=7)
    String physicianLicenseNumber,

    @NotNull
    LocalDateTime firstDateTime,

    @NotNull
    LocalDateTime lastDateTime
) {
    
}
