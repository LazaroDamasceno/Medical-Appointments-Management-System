package com.api.v1.medical_appointment.cancel;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.helper.constant.HttpStatusCodes;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointment")
@RequiredArgsConstructor
class CancelMedicalAppointmentController {

    private final CancelMedicalAppointmentService service;

    @PatchMapping
    @Transactional
    public ResponseEntity<Void> cancel(@NotNull @RequestBody CancelMedicalAppointmentDTO dto) {
        service.cancel(dto);
        return HttpStatusCodes.NO_CONTENT_204;
    }
    
}
