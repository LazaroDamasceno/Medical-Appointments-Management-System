package com.api.v1.medical_appointment.find_by.find_by_physician.scheduled;

import java.util.List;
import java.time.LocalDateTime;

import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindScheduledMedicalAppointmentByPhysicianService {

    List<MedicalAppointment> find(
        @NotNull @Size(min=7, max=7) String physicianLicenseNumber,
        @NotNull LocalDateTime firstDateTime,
        @NotNull LocalDateTime lastDateTime
    );

    List<MedicalAppointment> findByPatient(
        @NotNull @Size(min=7, max=7) String physicianLicenseNumber,
        @NotNull @Size(min=9, max=9) String ssn,
        @NotNull LocalDateTime firstDateTime,
        @NotNull LocalDateTime lastDateTime
    );
    
}
