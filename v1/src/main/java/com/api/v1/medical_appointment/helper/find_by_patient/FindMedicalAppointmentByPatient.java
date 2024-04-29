package com.api.v1.medical_appointment.helper.find_by_patient;

import java.time.ZonedDateTime;

import com.api.v1.helper.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;

public interface FindMedicalAppointmentByPatient {
    
    MedicalAppointment findByPatient(@SSN String ssn, @NotNull ZonedDateTime dateTime);

}
