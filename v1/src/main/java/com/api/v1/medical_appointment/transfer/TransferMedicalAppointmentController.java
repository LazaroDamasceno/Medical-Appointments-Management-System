package com.api.v1.medical_appointment.transfer;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/transfered-medical-appointment")
@RequiredArgsConstructor
public class TransferMedicalAppointmentController {
     
    private final TransferMedicalAppointmentService service;

    @PostMapping
    @Transactional
    public HttpStatus transfer(@NotNull @RequestBody TransferMedicalAppointmentDTO dto) {
        service.transfer(dto);
        return HttpStatus.CREATED;
    }
    
}
