package com.api.v1.medical_appointment.cancel;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;

public interface CancelMedicalAppointment {
    
    ResponseEntity<Void> cancel(@NotNull CancelMedicalAppointmentDTO dto);

}
