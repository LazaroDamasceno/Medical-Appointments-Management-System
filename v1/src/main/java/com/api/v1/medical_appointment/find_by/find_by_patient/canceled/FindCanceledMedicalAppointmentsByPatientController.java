package com.api.v1.medical_appointment.find_by.find_by_patient.canceled;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindCanceledMedicalAppointmentsByPatientController {

    ResponseEntity<List<MedicalAppointment>> findAll(@NotNull @Size(min=9, max=9) String ssn, 
                                                        @NotNull LocalDateTime firstDateTime, 
                                                        @NotNull LocalDateTime lastDateTime);
    
}
