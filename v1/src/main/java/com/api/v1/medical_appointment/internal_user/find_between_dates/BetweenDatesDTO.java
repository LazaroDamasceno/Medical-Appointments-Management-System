package com.api.v1.medical_appointment.internal_user.find_between_dates;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record BetweenDatesDTO(
    @NotNull
    LocalDateTime firstDateTime,

    @NotNull
    LocalDateTime lastDateTime
) {
    
}
