package com.api.v1.medical_appointment.find_by.find_by_physician.scheduled;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindScheduledMedicalAppointmentsByPhysicianController {

    ResponseEntity<List<MedicalAppointment>> find(@NotNull @Size(min = 7, max = 7) String physicianLicenseNumber,
                                        @NotNull String firstDateTime, 
                                        @NotNull String lastDateTime
    );

    ResponseEntity<List<MedicalAppointment>> findAll(@NotNull @Size(min = 7, max = 7) String physicianLicenseNumber);
    
    ResponseEntity<List<MedicalAppointment>> findByPatient(@NotNull @Size(min = 7, max = 7) String physicianLicenseNumber,
                                                @NotNull @Size(min = 9, max = 9) String ssn, 
                                                @NotNull String firstDateTime,
                                                @NotNull String lastDateTime
    );
    
}
