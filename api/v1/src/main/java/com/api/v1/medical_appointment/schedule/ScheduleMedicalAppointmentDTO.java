package com.api.v1.medical_appointment.schedule;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ScheduleMedicalAppointmentDTO(
    @NotBlank
    @Size(min=9, max=9)
    String ssn,

    @NotBlank
    @Size(min=7, max=7)
    String mln,

    @NotNull
    Date dateTime
) {
    
}
