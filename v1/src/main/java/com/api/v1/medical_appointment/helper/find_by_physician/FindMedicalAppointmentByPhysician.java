package com.api.v1.medical_appointment.helper.find_by_physician;

import java.time.ZonedDateTime;

import com.api.v1.helper.customized_annotations.PhysicianLicenseNumber;
import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;

public interface FindMedicalAppointmentByPhysician {
    
    MedicalAppointment findByPhysician(@PhysicianLicenseNumber String physicianLicenseNumber, @NotNull ZonedDateTime dateTime);

}
