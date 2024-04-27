package com.api.v1.medical_appointment.find_by.find_by_patient.finished;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.helper.customized_annotations.PhysicianLicenseNumber;
import com.api.v1.helper.customized_annotations.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by.dto.BetweenDatesTimesDTO;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointments/finished/by-patient")
@RequiredArgsConstructor
public class FindFinishedMedicalAppointmentsByPatientController {

    private final FindFinishedMedicalAppointmentsByPatientService service;

    @Transactional(readOnly = true)
    @GetMapping("{ssn}")
    public ResponseEntity<List<MedicalAppointment>> find(@SSN @PathVariable String ssn, @NotNull @RequestBody BetweenDatesTimesDTO dto) {
        return ResponseEntity.ok(service.find(ssn, dto));
    }

    @Transactional(readOnly = true)
    @GetMapping("{ssn}/{physicianLicenseNumber}")
    public ResponseEntity<List<MedicalAppointment>> findByPhysician(@SSN @PathVariable String ssn, 
                                                                    @PhysicianLicenseNumber @PathVariable String physicianLicenseNumber,
                                                                    @NotNull @RequestBody BetweenDatesTimesDTO dto) {
        return ResponseEntity.ok(service.findByPhysician(ssn, physicianLicenseNumber, dto));
    }

    @Transactional(readOnly = true)
    @GetMapping("ssn/{ssn}")
    public ResponseEntity<List<MedicalAppointment>> findAll(@SSN @PathVariable String ssn) {
        return ResponseEntity.ok(service.findAll(ssn));
    }
    

}
