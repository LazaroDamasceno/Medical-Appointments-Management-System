package com.api.v1.medical_appointment.cancel;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.auxiliary.SSN;
import com.api.v1.constants.HttpStatusCodes;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointment")
@RequiredArgsConstructor
public class CancelMedicalAppointmentController {

    private final CancelMedicalAppointmentService service;

    @PatchMapping("{ssn}/{dateTime}")
    @Transactional
    public ResponseEntity<Void> cancel(@SSN @PathVariable String ssn, @NotNull @PathVariable String dateTime) {
        service.cancel(ssn, dateTime);
        return HttpStatusCodes.NO_CONTENT_204;
    }
    
}
