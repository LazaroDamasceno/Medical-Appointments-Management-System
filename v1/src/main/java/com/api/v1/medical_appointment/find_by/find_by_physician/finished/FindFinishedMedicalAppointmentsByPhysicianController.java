package com.api.v1.medical_appointment.find_by.find_by_physician.finished;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.auxiliary.PhysicianLicenseNumber;
import com.api.v1.auxiliary.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointments/finished/by-physician")
@RequiredArgsConstructor
public class FindFinishedMedicalAppointmentsByPhysicianController {

    private final FindFinishedMedicalAppointmentsByPhysicianService service;

    @GetMapping("{physicianLicenseNumber}/{firstDateTime}/{lastDateTime}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalAppointment>> find(
            @PhysicianLicenseNumber @PathVariable String physicianLicenseNumber,
            @NotNull @PathVariable String firstDateTime, 
            @NotNull @PathVariable String lastDateTime
    ) {
        return ResponseEntity.ok(service.find(physicianLicenseNumber, firstDateTime, lastDateTime));
    }

    @GetMapping("and-by-patient/{physicianLicenseNumber}/{ssn}/{firstDateTime}/{lastDateTime}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalAppointment>> findByPatient(
            @PhysicianLicenseNumber @PathVariable String physicianLicenseNumber, 
            @SSN @PathVariable @Size(min = 9, max = 9) String ssn,
            @NotNull @PathVariable String firstDateTime, 
            @NotNull @PathVariable String lastDateTime
    ) {
        return ResponseEntity.ok(service.findByPatient(physicianLicenseNumber, ssn, firstDateTime, lastDateTime));
    }

    @GetMapping("{physicianLicenseNumber}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalAppointment>> findAll(@PhysicianLicenseNumber @PathVariable String physicianLicenseNumber) {
        return ResponseEntity.ok(service.findAll(physicianLicenseNumber));
    }
    
}
