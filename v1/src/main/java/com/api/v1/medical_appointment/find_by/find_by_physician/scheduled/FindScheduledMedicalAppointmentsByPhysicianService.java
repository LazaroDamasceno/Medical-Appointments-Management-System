package com.api.v1.medical_appointment.find_by.find_by_physician.scheduled;

import java.util.List;

import com.api.v1.helpers.PhysicianLicenseNumber;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by.dto.BetweenDatesTimesDTO;

import jakarta.validation.constraints.NotNull;


public interface FindScheduledMedicalAppointmentsByPhysicianService {

    List<MedicalAppointment> find(
        @PhysicianLicenseNumber String physicianLicenseNumber,
        @NotNull BetweenDatesTimesDTO dto   
    );
    
}
