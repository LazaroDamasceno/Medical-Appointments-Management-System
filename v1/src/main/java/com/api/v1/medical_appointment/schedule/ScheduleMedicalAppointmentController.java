package com.api.v1.medical_appointment.schedule;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.auxiliary.HttpStatusCodes;
import com.api.v1.auxiliary.PhysicianLicenseNumber;
import com.api.v1.auxiliary.SSN;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Future;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/new-medical-appointment")
@RequiredArgsConstructor
public class ScheduleMedicalAppointmentController {

    private final ScheduleMedicalAppointmentService service;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> schedule(@SSN @PathVariable String ssn, @PhysicianLicenseNumber @PathVariable String physicianLicenseNumber, @NotNull @Future @PathVariable String dateTime) {
        service.schedule(ssn, physicianLicenseNumber, dateTime);
        return HttpStatusCodes.CREATED_201;
    }
    
}
