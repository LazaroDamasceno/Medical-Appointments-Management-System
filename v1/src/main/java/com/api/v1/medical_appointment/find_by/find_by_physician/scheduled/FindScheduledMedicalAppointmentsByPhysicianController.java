package com.api.v1.medical_appointment.find_by.find_by_physician.scheduled;

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
@RequestMapping("api/v1/medical-appointments/scheduled/by-physician")
@RequiredArgsConstructor
public class FindScheduledMedicalAppointmentsByPhysicianController {

    private final FindScheduledMedicalAppointmentsByPhysicianService service;

    @Transactional(readOnly = true)
    @GetMapping("{physicianLicenseNumber}")
    public ResponseEntity<List<MedicalAppointment>> find(@PhysicianLicenseNumber @PathVariable String physicianLicenseNumber,
                                                        @NotNull @RequestBody BetweenDatesTimesDTO dto
    ) {
        return ResponseEntity.ok(service.find(physicianLicenseNumber, dto));
    }

    @Transactional(readOnly = true)
    @GetMapping("and-by-patient/{physicianLicenseNumber}/{ssn}/{firstDateTime}/{lastDateTime}")
    public ResponseEntity<List<MedicalAppointment>> findByPatient(@PhysicianLicenseNumber @PathVariable String physicianLicenseNumber, 
                                                                    @SSN @PathVariable String ssn,
                                                                    @NotNull @RequestBody BetweenDatesTimesDTO dto
    ) {
        return ResponseEntity.ok(service.findByPatient(physicianLicenseNumber, ssn, dto));
    }

    @Transactional(readOnly = true)
    @GetMapping("license-number/{physicianLicenseNumber}")
    public ResponseEntity<List<MedicalAppointment>> findAll(@PhysicianLicenseNumber @PathVariable String physicianLicenseNumber) {
        return ResponseEntity.ok(service.findAll(physicianLicenseNumber));
    }
    
}
