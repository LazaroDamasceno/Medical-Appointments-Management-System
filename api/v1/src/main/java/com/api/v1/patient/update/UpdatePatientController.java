package com.api.v1.patient.update;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/patient")
@RequiredArgsConstructor
public class UpdatePatientController implements UpdatePatient {
    
    private final UpdatePatientService service;

    @Override
    @Transactional
    @PutMapping("{ssn}")
    public ResponseEntity<Void> update(
        @NotNull 
        @Size(min=9, max=9) 
        @PathVariable
        String ssn, 
        
        @NotNull
        @RequestBody
        UpdatePatientDTO dto
    ) {
        return service.update(ssn, dto);
    }
    
}
