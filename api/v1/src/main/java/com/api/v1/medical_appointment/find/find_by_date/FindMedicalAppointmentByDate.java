package com.api.v1.medical_appointment.find.find_by_date;

import java.util.Date;

import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindMedicalAppointmentByDate {
    
    MedicalAppointment findByDate(
        @NotBlank 
        @Size(min=9, max=9)
        String ssn, 

        @NotBlank 
        @Size(min=7, max=7)
        String mln, 

        @NotNull
        Date dateTime
    );

}
