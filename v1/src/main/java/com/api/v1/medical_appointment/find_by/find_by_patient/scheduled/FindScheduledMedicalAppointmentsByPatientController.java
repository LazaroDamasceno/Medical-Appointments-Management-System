package com.api.v1.medical_appointment.find_by.find_by_patient.scheduled;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.auxiliary.customized_annotations.PhysicianLicenseNumber;
import com.api.v1.auxiliary.customized_annotations.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by.BetweenDatesTimesDTO;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointments/scheduled/by-patient")
@RequiredArgsConstructor
public class FindScheduledMedicalAppointmentsByPatientController {

    private final FindScheduledMedicalAppointmentsByPatientService service;

    @GetMapping("{ssn}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalAppointment>> find(@SSN @PathVariable String ssn, @NotNull @RequestBody BetweenDatesTimesDTO dto) {
        return ResponseEntity.ok(service.find(ssn, dto));
    }

    @Transactional(readOnly = true)
    @GetMapping("and-by-physician/{ssn}/{physicianLicenseNumber}/{firstDateTime}/{lastDateTime}")
    public ResponseEntity<List<MedicalAppointment>> findByPhysician(@SSN @PathVariable String ssn,
                                                                    @PhysicianLicenseNumber @PathVariable String physicianLicenseNumber,
                                                                    @NotNull @RequestBody BetweenDatesTimesDTO dto
    ) {
        return ResponseEntity.ok(service.findByPhysician(ssn, physicianLicenseNumber, dto));
    }

    @GetMapping("ssn/{ssn}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalAppointment>> find(@SSN @PathVariable String ssn) {
        return ResponseEntity.ok(service.findAll(ssn));
    }
    
}
