package com.api.v1.medical_appointment.find_by.find_by_patient.finished;

import java.util.List;

import com.api.v1.helpers.PhysicianLicenseNumber;
import com.api.v1.helpers.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;
import com.api.v1.medical_appointment.find_by.dto.BetweenDatesTimesDTO;

import jakarta.validation.constraints.NotNull;

public interface FindFinishedMedicalAppointmentsByPatientService {

    List<MedicalAppointment> findAll(@SSN String ssn);

    List<MedicalAppointment> find(@SSN String ssn, @NotNull BetweenDatesTimesDTO dto);

    List<MedicalAppointment> findByPhysician(@SSN String ssn, 
                                            @PhysicianLicenseNumber String physicianLicenseNumber,
                                            @NotNull BetweenDatesTimesDTO dto);
    
}
