package com.api.v1.medical_appointment.helper.find_by_patient;

import java.time.LocalDateTime;

import com.api.v1.helpers.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;

public interface FindMedicalAppointmentByPatient {
    
    MedicalAppointment findByPatient(@SSN String ssn, @NotNull LocalDateTime dateTime);

}
