package com.api.v1.medical_appointment.find.finished;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.helpers.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointment/finished")
@RequiredArgsConstructor
public class FindFinishedMedicalAppointmentController {

    private final FindFinishedMedicalAppointmentService service;

    @Transactional(readOnly = true)
    @GetMapping("by-patient/{ssn}/{firstDateTime}/{lastDateTime}")
    public List<MedicalAppointment> findByPatient(
        @SSN @PathVariable String ssn, 
        @NotNull @PathVariable LocalDateTime firstDateTime, 
        @NotNull @PathVariable LocalDateTime lastDateTime
    ) {
        return service.findByPatient(ssn, firstDateTime, lastDateTime);
    }

    @Transactional(readOnly = true)
    @GetMapping("by-physician/{ssn}/{firstDateTime}/{lastDateTime}")
    public List<MedicalAppointment> findByPhysicain(
        @SSN String physicianLicenseNumber, 
        @NotNull @PathVariable LocalDateTime firstDateTime, 
        @NotNull @PathVariable LocalDateTime lastDateTime
    ) {
        return service.findByPhysicain(physicianLicenseNumber, firstDateTime, lastDateTime);
    }
    
}
