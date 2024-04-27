package com.api.v1.medical_appointment.find_by.dto;

import com.api.v1.helper.customized_annotations.DateTimeFormat;

public record BetweenDatesTimesDTO(
    @DateTimeFormat String firstDateTime, 
    @DateTimeFormat String lastDateTime
) {
    
}
