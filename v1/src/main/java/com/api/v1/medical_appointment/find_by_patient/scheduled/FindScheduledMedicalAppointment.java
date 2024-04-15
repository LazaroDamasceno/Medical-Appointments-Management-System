package com.api.v1.medical_appointment.find_by_patient.scheduled;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by_patient.MedicalAppointmentInputWithoutPhysicianDTO;
import com.api.v1.medical_appointment.find_by_patient.MedicalAppointmentInputWithPhysicianDTO;

import jakarta.validation.constraints.NotNull;

public interface FindScheduledMedicalAppointment {

    ResponseEntity<List<MedicalAppointment>> find(@NotNull MedicalAppointmentInputWithoutPhysicianDTO dto);

    ResponseEntity<List<MedicalAppointment>> findByPhysician(@NotNull MedicalAppointmentInputWithPhysicianDTO dto);

}
