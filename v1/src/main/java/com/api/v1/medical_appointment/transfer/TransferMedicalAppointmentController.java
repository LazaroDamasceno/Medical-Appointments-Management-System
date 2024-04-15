package com.api.v1.medical_appointment.transfer;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;

public interface TransferMedicalAppointmentController {

    ResponseEntity<Void> transfer(@NotNull TransferMedicalAppointmentDTO dto);
    
}
