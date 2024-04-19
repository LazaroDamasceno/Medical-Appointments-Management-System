package com.api.v1.medical_appointment.find_by.find_by_patient.scheduled;

import java.time.LocalDateTime;
import java.util.List;

import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindScheduledMedicalAppointmentsByPatientService {

    List<MedicalAppointment> find(@NotNull @Size(min=9, max=9) String ssn, 
                            @NotNull LocalDateTime firstDateTime, 
                            @NotNull LocalDateTime lastDateTime);

    List<MedicalAppointment> findAll(@NotNull @Size(min=9, max=9) String ssn);

    List<MedicalAppointment> findByPhysician(@NotNull @Size(min=9, max=9) String ssn, 
                                            @NotNull @Size(min=7, max=7) String physicianLicenseNumber,
                                            @NotNull LocalDateTime firstDateTime, 
                                            @NotNull LocalDateTime lastDateTime);
    
}
