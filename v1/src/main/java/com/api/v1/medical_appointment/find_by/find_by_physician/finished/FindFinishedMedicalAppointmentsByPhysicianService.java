package com.api.v1.medical_appointment.find_by.find_by_physician.finished;

import java.util.List;

import com.api.v1.auxiliary.customized_annotations.PhysicianLicenseNumber;
import com.api.v1.auxiliary.customized_annotations.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by.BetweenDatesTimesDTO;

import jakarta.validation.constraints.NotNull;

public interface FindFinishedMedicalAppointmentsByPhysicianService {

    List<MedicalAppointment> find(
        @PhysicianLicenseNumber String physicianLicenseNumber, 
        @NotNull BetweenDatesTimesDTO dto
    );

    List<MedicalAppointment> findAll(@PhysicianLicenseNumber String physicianLicenseNumber);

    List<MedicalAppointment> findByPatient(
        @PhysicianLicenseNumber String physicianLicenseNumber, 
        @SSN String ssn,
        @NotNull BetweenDatesTimesDTO dto
    );
    
}
