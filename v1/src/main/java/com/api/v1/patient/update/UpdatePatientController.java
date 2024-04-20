package com.api.v1.patient.update;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.constants.HttpStatusCodes;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/patient")
@RequiredArgsConstructor
public class UpdatePatientController {

    private final UpdatePatientService service;

    @PutMapping
    @Transactional
    public ResponseEntity<Void> update(@NotNull @RequestBody UpdatePatientDTO dto) {
        service.update(dto);
        return HttpStatusCodes.NO_CONTENT_204;
    }
    
}
