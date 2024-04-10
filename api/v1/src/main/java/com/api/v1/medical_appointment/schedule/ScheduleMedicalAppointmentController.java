package com.api.v1.medical_appointment.schedule;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointment")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class ScheduleMedicalAppointmentController implements ScheduleMedicalAppointment {

    private final ScheduleMedicalAppointmentService service;

    @Override
    @PostMapping
    @Transactional
    public ResponseEntity<Void> schedule(@NotNull @RequestBody ScheduleMedicalAppointmentDTO dto) {
        return service.schedule(dto);
    }
    
}
