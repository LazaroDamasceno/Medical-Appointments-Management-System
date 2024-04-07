package com.api.v1.medical_appointment.cancel;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CancelMedicalAppointmentDTO(
    @NotBlank
    @Size(min=9, max=9)
    String ssn,

    @NotNull
    Date dateTime
) {
    
}
