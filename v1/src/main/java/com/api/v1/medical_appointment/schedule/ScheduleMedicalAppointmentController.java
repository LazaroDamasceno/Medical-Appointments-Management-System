package com.api.v1.medical_appointment.schedule;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;

public interface ScheduleMedicalAppointmentController {

    ResponseEntity<Void> schedule(@NotNull ScheduleMedicalAppointmentDTO dto);
    
}
