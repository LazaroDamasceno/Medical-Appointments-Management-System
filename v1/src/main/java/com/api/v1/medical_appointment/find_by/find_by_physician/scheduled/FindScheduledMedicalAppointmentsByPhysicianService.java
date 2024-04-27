package com.api.v1.medical_appointment.find_by.find_by_physician.scheduled;

import java.util.List;

import com.api.v1.auxiliary.customized_annotations.PhysicianLicenseNumber;
import com.api.v1.auxiliary.customized_annotations.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by.BetweenDatesTimesDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindScheduledMedicalAppointmentsByPhysicianService {

    List<MedicalAppointment> find(
        @NotNull @Size(min=7, max=7) String physicianLicenseNumber,
        @NotNull BetweenDatesTimesDTO dto   
    );

    List<MedicalAppointment> findAll(@NotNull @Size(min=7, max=7) String physicianLicenseNumber);

    List<MedicalAppointment> findByPatient(
        @PhysicianLicenseNumber String physicianLicenseNumber,
        @SSN String ssn,
        @NotNull BetweenDatesTimesDTO dto
    );
    
}
