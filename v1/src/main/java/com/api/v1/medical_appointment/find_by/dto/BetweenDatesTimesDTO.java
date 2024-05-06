package com.api.v1.medical_appointment.find_by.dto;

import java.time.LocalDateTime;

public record BetweenDatesTimesDTO(
    LocalDateTime firstDateTime, 
    LocalDateTime lastDateTime
) {
    
}
