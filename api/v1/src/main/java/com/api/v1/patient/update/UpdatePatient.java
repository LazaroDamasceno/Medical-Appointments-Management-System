package com.api.v1.patient.update;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface UpdatePatient {

    ResponseEntity<Void> update(@NotNull @Size(min=9, max=9) String ssn, @NotNull UpdatePatientDTO dto);
    
} 
