package com.api.v1.medical_appointment.find_for_internal_user.find_by_date;

import java.time.LocalDateTime;

import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindMedicalAppointmentByDate {
    
    MedicalAppointment findByDate(
        @NotNull 
        @Size(min=9, max=9)
        String ssn, 

        @NotNull 
        @Size(min=7, max=7)
        String physicanLicenseNumber, 

        @NotNull
        LocalDateTime dateTime
    );

}
