package com.api.v1.medical_appointment.schedule;

import com.api.v1.auxiliary.PhysicianLicenseNumber;
import com.api.v1.auxiliary.SSN;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public interface ScheduleMedicalAppointmentService {

    void schedule(@SSN String ssn, @PhysicianLicenseNumber String physicianLicenseNumber, @NotNull @Future String dateTime);
    
} 
