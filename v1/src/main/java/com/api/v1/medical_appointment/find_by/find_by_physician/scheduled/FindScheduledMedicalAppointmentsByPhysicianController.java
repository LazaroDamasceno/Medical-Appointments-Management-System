package com.api.v1.medical_appointment.find_by.find_by_physician.scheduled;

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
@RequestMapping("api/v1/medical-appointments/scheduled/by-physician")
@RequiredArgsConstructor
public class FindScheduledMedicalAppointmentsByPhysicianController {

    private final FindScheduledMedicalAppointmentsByPhysicianService service;

    @Transactional(readOnly = true)
    @GetMapping("{physicianLicenseNumber}/{firstDateTime}/{lastDateTime}")
    public ResponseEntity<List<MedicalAppointment>> find(@PhysicianLicenseNumber String physicianLicenseNumber,
                                                        @NotNull @PathVariable String firstDateTime, 
                                                        @NotNull @PathVariable String lastDateTime
    ) {
        return ResponseEntity.ok(service.find(physicianLicenseNumber, firstDateTime, lastDateTime));
    }

    @Transactional(readOnly = true)
    @GetMapping("and-by-patient/{physicianLicenseNumber}/{ssn}/{firstDateTime}/{lastDateTime}")
    public ResponseEntity<List<MedicalAppointment>> findByPatient(@PhysicianLicenseNumber String physicianLicenseNumber, 
                                                                @SSN String ssn,
                                                                @NotNull @PathVariable String firstDateTime, 
                                                                @NotNull @PathVariable String lastDateTime
    ) {
        return ResponseEntity.ok(service.findByPatient(physicianLicenseNumber, ssn, firstDateTime, lastDateTime));
    }

    @Transactional(readOnly = true)
    @GetMapping("{physicianLicenseNumber}")
    public ResponseEntity<List<MedicalAppointment>> findAll(@NotNull @Size(min = 7, max = 7) String physicianLicenseNumber) {
        return ResponseEntity.ok(service.findAll(physicianLicenseNumber));
    }
    
}
