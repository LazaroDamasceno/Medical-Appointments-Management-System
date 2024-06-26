package com.api.v1.medical_appointment.cancel;

import java.time.LocalDateTime;

import com.api.v1.helpers.SSN;

public record CancelMedicalAppointmentDTO(
    @SSN String ssn, 
    LocalDateTime dateTime
) {
    
}
