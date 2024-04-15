package com.api.v1.medical_appointment.find_by_patient;

import com.api.v1.medical_appointment.find_for_internal_user.find_between_dates.BetweenDatesDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MedicalAppointmentInputWithoutPhysicianDTO(
    @NotBlank
    @Size(min=9, max=9)
    String ssn,

    @NotNull
    BetweenDatesDTO betweenDatesDTO
) {
    
}
