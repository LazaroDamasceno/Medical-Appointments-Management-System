package com.api.v1.medical_appointment.find_by.find_by_patient.finished;

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
@RequestMapping("api/v1/medical-appointments/finished/by-patient")
@RequiredArgsConstructor
public class FindFinishedMedicalAppointmentsByPatientControllerImpl implements FindFinishedMedicalAppointmentsByPatientController {

    private final FindFinishedMedicalAppointmentsByPatientService service;

    @Override
    @Transactional(readOnly = true)
    @GetMapping("{ssn}/{firstDateTime}/{lastDateTime}")
    public ResponseEntity<List<MedicalAppointment>> find(@NotNull @PathVariable @Size(min=9, max=9) String ssn, 
                                                        @NotNull @PathVariable LocalDateTime firstDateTime, 
                                                        @NotNull @PathVariable LocalDateTime lastDateTime
    ) {
        return ResponseEntity.ok(service.find(ssn, firstDateTime, lastDateTime));
    }

    @Override
    @Transactional(readOnly = true)
    @GetMapping("/and-by-physician/{ssn}/{physicianLicenseNumber}/{firstDateTime}/{lastDateTime}")
    public ResponseEntity<List<MedicalAppointment>> findByPhysician(@NotNull @PathVariable @Size(min=9, max=9) String ssn, 
                                                                    @NotNull @PathVariable @Size(min=7, max=7) String physicianLicenseNumber,
                                                                    @NotNull @PathVariable LocalDateTime firstDateTime, 
                                                                    @NotNull @PathVariable LocalDateTime lastDateTime
    ) {
        return ResponseEntity.ok(service.findByPhysician(ssn, physicianLicenseNumber, firstDateTime, lastDateTime));
    }
    
}
