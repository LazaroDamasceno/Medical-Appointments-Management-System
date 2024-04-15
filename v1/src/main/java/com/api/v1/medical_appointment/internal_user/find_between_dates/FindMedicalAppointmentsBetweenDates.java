package com.api.v1.medical_appointment.internal_user.find_between_dates;

import java.util.List;

import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;

public interface FindMedicalAppointmentsBetweenDates {
    
    List<MedicalAppointment> findAll(@NotNull BetweenDatesDTO dto);
    
}
