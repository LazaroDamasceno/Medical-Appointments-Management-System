package com.api.v1.medical_appointment.add_medical_notes;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;

public interface AddMedicalNotesController {

    public ResponseEntity<Void> add(@NotNull MedicalNotesDTO dto);
    
}
