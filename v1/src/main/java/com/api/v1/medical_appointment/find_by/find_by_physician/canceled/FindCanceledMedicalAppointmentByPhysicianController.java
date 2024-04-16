package com.api.v1.medical_appointment.find_by.find_by_physician.canceled;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindCanceledMedicalAppointmentByPhysicianController {

    ResponseEntity<List<MedicalAppointment>> find(@NotNull @Size(min = 7, max = 7) String physicianLicenseNumber);
    
}
