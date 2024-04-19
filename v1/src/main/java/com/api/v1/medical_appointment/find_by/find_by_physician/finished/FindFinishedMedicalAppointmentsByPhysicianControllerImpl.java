package com.api.v1.medical_appointment.find_by.find_by_physician.finished;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointments/finished/by-physician")
@RequiredArgsConstructor
public class FindFinishedMedicalAppointmentsByPhysicianControllerImpl implements FindFinishedMedicalAppointmentsByPhysicianController {

    private final FindFinishedMedicalAppointmentsByPhysicianService service;

    @Override
    @GetMapping("{physicianLicenseNumber}/{firstDateTime}/{lastDateTime}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalAppointment>> find(
            @NotNull @PathVariable @Size(min = 7, max = 7) String physicianLicenseNumber,
            @NotNull @PathVariable LocalDateTime firstDateTime, 
            @NotNull @PathVariable LocalDateTime lastDateTime
    ) {
        return ResponseEntity.ok(service.find(physicianLicenseNumber, firstDateTime, lastDateTime));
    }

    @Override
    @GetMapping("and-by-patient/{physicianLicenseNumber}/{ssn}/{firstDateTime}/{lastDateTime}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalAppointment>> findByPatient(
            @NotNull @PathVariable @Size(min = 7, max = 7) String physicianLicenseNumber, 
            @NotNull @PathVariable @Size(min = 9, max = 9) String ssn,
            @NotNull @PathVariable LocalDateTime firstDateTime, 
            @NotNull @PathVariable LocalDateTime lastDateTime
    ) {
        return ResponseEntity.ok(service.findByPatient(physicianLicenseNumber, ssn, firstDateTime, lastDateTime));
    }

    @Override
    @GetMapping("{physicianLicenseNumber}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalAppointment>> findAll(@NotNull @PathVariable @Size(min = 7, max = 7) String physicianLicenseNumber) {
        return ResponseEntity.ok(service.findAll(physicianLicenseNumber));
    }
    
}
