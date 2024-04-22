package com.api.v1.medical_appointment.find_by.find_by_patient.scheduled;

import java.util.List;

import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindScheduledMedicalAppointmentsByPatientService {

    List<MedicalAppointment> find(@NotNull @Size(min=9, max=9) String ssn, 
                            @NotNull String firstDateTime, 
                            @NotNull String lastDateTime);

    List<MedicalAppointment> findAll(@NotNull @Size(min=9, max=9) String ssn);

    List<MedicalAppointment> findByPhysician(@NotNull @Size(min=9, max=9) String ssn, 
                                            @NotNull @Size(min=7, max=7) String physicianLicenseNumber,
                                            @NotNull String firstDateTime, 
                                            @NotNull String lastDateTime);
    
}
