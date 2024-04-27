package com.api.v1.medical_appointment.find_by;

import com.api.v1.auxiliary.customized_annotations.DateTimeFormat;

public record BetweenDatesTimesDTO(
    @DateTimeFormat String firstDateTime, 
    @DateTimeFormat String lastDateTime
) {
    
}
