package com.api.v1.medical_appointment.cancel;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointment")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173/")
public class CancelMedicalAppointmentController implements CancelMedicalAppointment {

    private final CancelMedicalAppointmentService service;

    @Override
    @PatchMapping
    @Transactional
    public ResponseEntity<Void> cancel(@NotNull @RequestBody CancelMedicalAppointmentDTO dto) {
        return service.cancel(dto);
    }
    
}
