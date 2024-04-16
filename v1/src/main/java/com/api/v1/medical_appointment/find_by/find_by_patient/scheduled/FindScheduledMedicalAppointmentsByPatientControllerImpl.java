package com.api.v1.medical_appointment.find_by.find_by_patient.scheduled;

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
@RequestMapping("api/v1/medical-appointments/scheduled/by-patient")
@RequiredArgsConstructor
public class FindScheduledMedicalAppointmentsByPatientControllerImpl implements FindScheduledMedicalAppointmentsByPatientController {

    private final FindScheduledMedicalAppointmentsByPatientService service;

    @Override
    @GetMapping("{ssn}/{firstDateTime}/{lastDateTime}")
    @Transactional(readOnly = true)
    public ResponseEntity<List<MedicalAppointment>> find(@NotNull @PathVariable @Size(min=9, max=9) String ssn, 
                                                            @NotNull LocalDateTime firstDateTime, 
                                                            @NotNull LocalDateTime lastDateTime
    ) {
        return ResponseEntity.ok(service.find(ssn, firstDateTime, lastDateTime));
    }

    @Override
    @Transactional(readOnly = true)
    @GetMapping("and-by-physician/{ssn}/{physicianLicenseNumber}/{firstDateTime}/{lastDateTime}")
    public ResponseEntity<List<MedicalAppointment>> findByPhysician(@NotNull @PathVariable @Size(min=9, max=9) String ssn, 
                                                                    @NotNull @PathVariable @Size(min=7, max=7) String physicianLicenseNumber,
                                                                    @NotNull @PathVariable LocalDateTime firstDateTime, 
                                                                    @NotNull @PathVariable LocalDateTime lastDateTime
    ) {
        return ResponseEntity.ok(service.findByPhysician(ssn, physicianLicenseNumber, firstDateTime, lastDateTime));
    }
    
}
