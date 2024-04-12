package com.api.v1.medical_appointment.transfer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointment")
@RequiredArgsConstructor
public class TransferMedicalAppointmentController implements TransferMedicalAppointment {
    
    private final TransferMedicalAppointmentService service;

    @Override
    @PostMapping
    public ResponseEntity<Void> transfer(@RequestBody TransferMedicalAppointmentDTO dto) {
        return service.transfer(dto);
    }
    
}
