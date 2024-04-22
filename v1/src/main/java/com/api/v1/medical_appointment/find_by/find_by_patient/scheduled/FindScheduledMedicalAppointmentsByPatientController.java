package com.api.v1.medical_appointment.find_by.find_by_patient.scheduled;

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
@RequestMapping("api/v1/medical-appointments/scheduled/by-patient")
@RequiredArgsConstructor
public class FindScheduledMedicalAppointmentsByPatientController {

    private final FindScheduledMedicalAppointmentsByPatientService service;

    @GetMapping("{ssn}/{firstDateTime}/{lastDateTime}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalAppointment>> find(@SSN @PathVariable String ssn, 
                                                        @NotNull String firstDateTime, 
                                                        @NotNull String lastDateTime
    ) {
        return ResponseEntity.ok(service.find(ssn, firstDateTime, lastDateTime));
    }

    @Transactional(readOnly = true)
    @GetMapping("and-by-physician/{ssn}/{physicianLicenseNumber}/{firstDateTime}/{lastDateTime}")
    public ResponseEntity<List<MedicalAppointment>> findByPhysician(@SSN @PathVariable String ssn,
                                                                    @PhysicianLicenseNumber @PathVariable String physicianLicenseNumber,
                                                                    @NotNull @PathVariable String firstDateTime, 
                                                                    @NotNull @PathVariable String lastDateTime
    ) {
        return ResponseEntity.ok(service.findByPhysician(ssn, physicianLicenseNumber, firstDateTime, lastDateTime));
    }

    @GetMapping("{ssn}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalAppointment>> find(@SSN @PathVariable @Size(min = 9, max = 9) String ssn) {
        return ResponseEntity.ok(service.findAll(ssn));
    }
    
}
