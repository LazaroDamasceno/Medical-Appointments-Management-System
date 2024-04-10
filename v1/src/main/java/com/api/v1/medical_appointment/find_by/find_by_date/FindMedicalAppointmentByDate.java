package com.api.v1.medical_appointment.find_by.find_by_date;

import java.util.Date;

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
        String mln, 

        @NotNull
        Date dateTime
    );

}
