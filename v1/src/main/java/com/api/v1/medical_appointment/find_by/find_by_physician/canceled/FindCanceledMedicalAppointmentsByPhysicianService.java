package com.api.v1.medical_appointment.find_by.find_by_physician.canceled;

import java.util.List;

import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindCanceledMedicalAppointmentsByPhysicianService {

    List<MedicalAppointment> find(@NotNull @Size(min=7, max=7) String physicianLicenseNumber);
    
}
