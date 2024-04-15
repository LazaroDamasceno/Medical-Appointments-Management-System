package com.api.v1.medical_appointment.find_by_patient.finished;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by_patient.MedicalAppointmentInputDTO;
import com.api.v1.medical_appointment.find_by_patient.MedicalAppointmentInputWithPhysicianDTO;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appointments/finished/by-patient")
@RequiredArgsConstructor
public class FindFinishedMedicalAppointmentsByPatientController implements FindFinishedMedicalAppointmentsByPatient {

    private final FindFinishedMedicalAppointmentsByPatientService service;

    @Override
    @Transactional
    @GetMapping
    public ResponseEntity<List<MedicalAppointment>> find(@NotNull @RequestBody MedicalAppointmentInputDTO dto) {
        return service.find(dto);
    }

    @Override
    @Transactional
    @GetMapping("/and-by-physician")
    public ResponseEntity<List<MedicalAppointment>> findByPhysician(@NotNull @RequestBody MedicalAppointmentInputWithPhysicianDTO dto) {
        return service.findByPhysician(dto);
    }
    
}
