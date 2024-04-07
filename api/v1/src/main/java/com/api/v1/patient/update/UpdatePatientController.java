package com.api.v1.patient.update;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/patient")
@RequiredArgsConstructor
public class UpdatePatientController implements UpdatePatient {
    
    private final UpdatePatientService service;

    @Override
    @Transactional
    @PutMapping
    public ResponseEntity<Void> update(@NotNull @RequestBody UpdatePatientDTO dto) {
        return service.update(dto);
    }
    
}
