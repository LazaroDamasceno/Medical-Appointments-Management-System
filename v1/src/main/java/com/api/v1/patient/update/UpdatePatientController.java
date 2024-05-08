package com.api.v1.patient.update;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.helpers.Constants;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/patient")
@RequiredArgsConstructor
public class UpdatePatientController {

    private final UpdatePatientService service;

    @PutMapping("{ssn}")
    public ResponseEntity<String> update(@NotNull @RequestBody UpdatePatientDTO dto) {
        service.update(dto);
        return ResponseEntity.status(204).body(Constants.NO_CONTENT_204);
    }
    
}
