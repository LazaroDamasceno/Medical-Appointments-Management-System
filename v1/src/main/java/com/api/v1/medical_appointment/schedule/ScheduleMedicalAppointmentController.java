package com.api.v1.medical_appointment.schedule;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/new-medical-appointment")
@RequiredArgsConstructor
class ScheduleMedicalAppointmentController {

    private final ScheduleMedicalAppointmentService service;

    @PostMapping
    @Transactional
    public HttpStatus schedule(@NotNull ScheduleMedicalAppointmentDTO dto) {
        service.schedule(dto);
        return HttpStatus.CREATED;
    }
    
}
