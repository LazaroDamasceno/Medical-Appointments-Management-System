package com.api.v1.medical_appointment.transfer;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.auxiliary.constant.HttpStatusCodes;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/transfered-medical-appointment")
@RequiredArgsConstructor
class TransferMedicalAppointmentController {
     
    private final TransferMedicalAppointmentService service;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> transfer(@NotNull @RequestBody TransferMedicalAppointmentDTO dto) {
        service.transfer(dto);
        return HttpStatusCodes.CREATED_201;
    }
    
}
