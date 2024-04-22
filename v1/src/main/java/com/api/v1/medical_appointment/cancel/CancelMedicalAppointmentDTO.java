package com.api.v1.medical_appointment.cancel;

import com.api.v1.auxiliary.SSN;

import jakarta.validation.constraints.NotNull;

public record CancelMedicalAppointmentDTO(
    @SSN String ssn, 
    @NotNull String dateTime
) {
    
}
