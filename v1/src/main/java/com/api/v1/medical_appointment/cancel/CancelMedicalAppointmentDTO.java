package com.api.v1.medical_appointment.cancel;

import org.springframework.format.annotation.DateTimeFormat;

import com.api.v1.helper.customized_annotations.SSN;

record CancelMedicalAppointmentDTO(
    @SSN String ssn, 
    @DateTimeFormat String dateTime
) {
    
}
