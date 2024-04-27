package com.api.v1.medical_appointment.internal_user.find_by_patient;

import java.time.LocalDateTime;

import com.api.v1.auxiliary.customized_annotations.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;

public interface FindMedicalAppointmentByPatient {
    
    MedicalAppointment findByPatient(@SSN String ssn, @NotNull LocalDateTime dateTime);

}
