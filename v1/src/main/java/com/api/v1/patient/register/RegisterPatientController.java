package com.api.v1.patient.register;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;

public interface RegisterPatientController {

    public ResponseEntity<Void> register(@NotNull RegisterPatientDTO dto);
    
}
