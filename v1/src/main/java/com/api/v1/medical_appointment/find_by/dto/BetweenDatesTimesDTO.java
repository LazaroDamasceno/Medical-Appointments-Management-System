package com.api.v1.medical_appointment.find_by.dto;

import com.api.v1.helper.DateTimeFormat;

public record BetweenDatesTimesDTO(
    @DateTimeFormat String firstDateTime, 
    @DateTimeFormat String lastDateTime
) {
    
}
