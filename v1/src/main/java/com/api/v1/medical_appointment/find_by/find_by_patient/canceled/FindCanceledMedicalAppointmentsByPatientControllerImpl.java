package com.api.v1.medical_appointment.find_by.find_by_patient.canceled;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.auxiliary.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appoointments/canceled/by-patient")
@RequiredArgsConstructor
public class FindCanceledMedicalAppointmentsByPatientControllerImpl {

    private final FindCanceledMedicalAppointmentsByPatientService service;
    
    @Transactional(readOnly = true)
    @GetMapping("{ssn}/{firstDateTime}/{lastDateTime}")
    public ResponseEntity<List<MedicalAppointment>> findAll(@SSN @PathVariable String ssn) {
        return ResponseEntity.ok(service.findAll(ssn));
    }
    
}
