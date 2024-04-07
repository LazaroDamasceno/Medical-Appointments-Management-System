package com.api.v1.medical_appointment.find.find_by_patient;

import java.util.Date;

import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindMedicalAppointmentByPatient {
    
    MedicalAppointment findByPatient(@NotNull @Size(min=9, max=9) String ssn, @NotNull Date dateTime);

}
