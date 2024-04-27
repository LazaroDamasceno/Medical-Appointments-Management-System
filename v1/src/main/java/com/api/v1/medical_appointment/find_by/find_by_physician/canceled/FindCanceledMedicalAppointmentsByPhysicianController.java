package com.api.v1.medical_appointment.find_by.find_by_physician.canceled;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.auxiliary.customized_annotations.PhysicianLicenseNumber;
import com.api.v1.medical_appointment.MedicalAppointment;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointments/canceled/by-physician")
@RequiredArgsConstructor
public class FindCanceledMedicalAppointmentsByPhysicianController {

    private final FindCanceledMedicalAppointmentsByPhysicianService service;

    @Transactional(readOnly = true)
    @GetMapping("{physicianLicenseNumber}")
    public ResponseEntity<List<MedicalAppointment>> find(@PhysicianLicenseNumber @PathVariable String physicianLicenseNumber) {
        return ResponseEntity.ok(service.find(physicianLicenseNumber));
    }
    
}
