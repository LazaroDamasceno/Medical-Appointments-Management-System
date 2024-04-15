package com.api.v1.medical_appointment.find_by_patient.canceled;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by_patient.MedicalAppointmentInputDTO;

import jakarta.validation.constraints.NotNull;

public interface FindCanceledMedicalAppointmentByPatient {

    ResponseEntity<List<MedicalAppointment>> findAll(@NotNull MedicalAppointmentInputDTO dto);
    
}
