package com.api.v1.medical_appointment.schedule;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.helpers.Constants;

import org.springframework.http.ResponseEntity;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/new-medical-appointment")
@RequiredArgsConstructor
public class ScheduleMedicalAppointmentController {

    private final ScheduleMedicalAppointmentService service;

    @PostMapping
    public ResponseEntity<String> schedule(@NotNull ScheduleMedicalAppointmentDTO dto) {
        service.schedule(dto);
        return ResponseEntity.status(201).body(Constants.CREATED_201);
    }
    
}
