package com.api.v1.medical_appointment.find_by.find_by_physician.finished;

import java.util.List;

import com.api.v1.auxiliary.DateTimeFormatForGET;
import com.api.v1.auxiliary.PhysicianLicenseNumber;
import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindFinishedMedicalAppointmentsByPhysicianService {

    List<MedicalAppointment> find(
        @PhysicianLicenseNumber String physicianLicenseNumber, 
        @DateTimeFormatForGET String firstDateTime, 
        @DateTimeFormatForGET String lastDateTime
    );

    List<MedicalAppointment> findAll(@PhysicianLicenseNumber String physicianLicenseNumber);

    List<MedicalAppointment> findByPatient(
        @NotNull @Size(min = 7, max = 7) String physicianLicenseNumber, 
        @NotNull @Size(min = 9, max = 9) String ssn,
        @DateTimeFormatForGET String firstDateTime, 
        @DateTimeFormatForGET String lastDateTime
    );
    
}
