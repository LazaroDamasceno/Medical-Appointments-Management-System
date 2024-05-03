package com.api.v1.patient.update;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/patient")
@RequiredArgsConstructor
class UpdatePatientController {

    private final UpdatePatientService service;

    @PutMapping("{ssn}")
    @Transactional
    public HttpStatus update(@NotNull @RequestBody UpdatePatientDTO dto) {
        service.update(dto);
        return HttpStatus.NO_CONTENT;
    }
    
}
