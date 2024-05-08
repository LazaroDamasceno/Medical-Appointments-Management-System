package com.api.v1.medical_appointment.helper.find_by_physician;

import java.time.LocalDateTime;

import com.api.v1.helpers.PhysicianLicenseNumber;
import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;

public interface FindMedicalAppointmentByPhysician {
    
    MedicalAppointment findByPhysician(@PhysicianLicenseNumber String physicianLicenseNumber, @NotNull LocalDateTime dateTime);

}
