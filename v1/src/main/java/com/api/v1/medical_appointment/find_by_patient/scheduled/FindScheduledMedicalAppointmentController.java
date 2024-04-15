package com.api.v1.medical_appointment.find_by_patient.scheduled;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by_patient.MedicalAppointmentInputWithoutPhysicianDTO;
import com.api.v1.medical_appointment.find_by_patient.MedicalAppointmentInputWithPhysicianDTO;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointments/scheduled/by-patient")
@RequiredArgsConstructor
public class FindScheduledMedicalAppointmentController implements FindScheduledMedicalAppointment {

    private final FindScheduledMedicalAppointmentService service;

    @Override
    @GetMapping
    @Transactional
    public ResponseEntity<List<MedicalAppointment>> find(@NotNull @RequestBody MedicalAppointmentInputWithoutPhysicianDTO dto) {
        return service.find(dto);
    }

    @Override
    @Transactional
    @GetMapping("and-by-physician")
    public ResponseEntity<List<MedicalAppointment>> findByPhysician(@NotNull @RequestBody MedicalAppointmentInputWithPhysicianDTO dto) {
        return service.findByPhysician(dto);
    }
    
}
