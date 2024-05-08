package com.api.v1.medical_appointment.transfer;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.helpers.Constants;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/transfered-medical-appointment")
@RequiredArgsConstructor
public class TransferMedicalAppointmentController {
     
    private final TransferMedicalAppointmentService service;

    @PostMapping
    public ResponseEntity<String> transfer(@NotNull @RequestBody TransferMedicalAppointmentDTO dto) {
        service.transfer(dto);
        return ResponseEntity.status(201).body(Constants.CREATED_201);
    }
    
}
