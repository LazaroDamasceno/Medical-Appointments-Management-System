package com.api.v1.medical_appointment.helper.find_by_date;

import java.time.ZonedDateTime;

import com.api.v1.helper.PhysicianLicenseNumber;
import com.api.v1.helper.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;

public interface FindMedicalAppointmentByDate {
    
    MedicalAppointment findByDate(
        @SSN String ssn, @NotNull @PhysicianLicenseNumber String physicianLicenseNumber, @NotNull ZonedDateTime dateTime
    );

}
