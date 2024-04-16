package com.api.v1.medical_appointment.find_by.find_by_physician.canceled;

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
@RequestMapping("api/v1/medical-appointments/canceled/by-physician")
@RequiredArgsConstructor
public class FindCanceledMedicalAppointmentsByPhysicianControllerImpl implements FindCanceledMedicalAppointmentsByPhysicianController {

    private final FindCanceledMedicalAppointmentsByPhysicianService service;

    @Override
    @Transactional(readOnly = true)
    @GetMapping("{physicianLicenseNumber}")
    public ResponseEntity<List<MedicalAppointment>> find(@NotNull @PathVariable @Size(min = 7, max = 7) String physicianLicenseNumber) {
        return ResponseEntity.ok(service.find(physicianLicenseNumber));
    }
    
}
