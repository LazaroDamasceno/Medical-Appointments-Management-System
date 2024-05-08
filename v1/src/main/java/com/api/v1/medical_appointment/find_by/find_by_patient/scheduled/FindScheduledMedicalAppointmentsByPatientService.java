package com.api.v1.medical_appointment.find_by.find_by_patient.scheduled;

import java.util.List;

import com.api.v1.helpers.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by.dto.BetweenDatesTimesDTO;

import jakarta.validation.constraints.NotNull;

public interface FindScheduledMedicalAppointmentsByPatientService {

    List<MedicalAppointment> find(@SSN String ssn, @NotNull BetweenDatesTimesDTO dto);
    
}
