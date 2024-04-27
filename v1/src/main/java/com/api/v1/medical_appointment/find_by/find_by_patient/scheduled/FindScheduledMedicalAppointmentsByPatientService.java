package com.api.v1.medical_appointment.find_by.find_by_patient.scheduled;

import java.util.List;

import com.api.v1.auxiliary.customized_annotations.PhysicianLicenseNumber;
import com.api.v1.auxiliary.customized_annotations.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by.BetweenDatesTimesDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindScheduledMedicalAppointmentsByPatientService {

    List<MedicalAppointment> find(@SSN String ssn, @NotNull BetweenDatesTimesDTO dto);

    List<MedicalAppointment> findAll(@NotNull @Size(min=9, max=9) String ssn);

    List<MedicalAppointment> findByPhysician(@SSN String ssn, 
                                            @PhysicianLicenseNumber String physicianLicenseNumber,
                                            @NotNull BetweenDatesTimesDTO dto);
    
}
