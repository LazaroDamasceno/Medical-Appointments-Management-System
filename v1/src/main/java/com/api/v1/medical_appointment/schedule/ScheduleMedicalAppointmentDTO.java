package com.api.v1.medical_appointment.schedule;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ScheduleMedicalAppointmentDTO(
    @NotNull
    @Size(min=9, max=9)
    String ssn,

    @NotNull
    @Size(min=7, max=7)
    String mln,

    @NotNull
    @Future
    LocalDateTime dateTime
) {
    
}
