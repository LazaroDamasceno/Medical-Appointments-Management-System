package com.api.v1.medical_appointment.internal_user.find_by_physician;

import java.time.LocalDateTime;

import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindMedicalAppointmentByPhysician {
    
    MedicalAppointment findByPhysician(@NotNull @Size(min=7, max=7) String physicanLicenseNumber, @NotNull LocalDateTime dateTime);

}
