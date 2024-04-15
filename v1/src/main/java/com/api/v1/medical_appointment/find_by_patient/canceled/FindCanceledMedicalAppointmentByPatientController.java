package com.api.v1.medical_appointment.find_by_patient.canceled;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by_patient.MedicalAppointmentInputDTO;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/medical-appoointments/canceled/by-patient")
@RequiredArgsConstructor
public class FindCanceledMedicalAppointmentByPatientController implements FindCanceledMedicalAppointmentByPatient {

    private final FindCanceledMedicalAppointmentByPatientService service;

    @Override
    @Transactional
    @GetMapping
    public ResponseEntity<List<MedicalAppointment>> findAll(@NotNull @RequestBody MedicalAppointmentInputDTO dto) {
        return service.findAll(dto);
    }
    
}
