package com.api.v1.medical_appointment.find_by.find_by_patient.finished;

import java.util.List;

import com.api.v1.auxiliary.PhysicianLicenseNumber;
import com.api.v1.auxiliary.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;

public interface FindFinishedMedicalAppointmentsByPatientService {

    List<MedicalAppointment> findAll(@SSN String ssn);

    List<MedicalAppointment> find(@SSN String ssn, 
                                @NotNull String firstDateTime, 
                                @NotNull String lastDateTime
    );

    List<MedicalAppointment> findByPhysician(@SSN String ssn, 
                                            @PhysicianLicenseNumber String physicianLicenseNumber,
                                            @NotNull String firstDateTime, 
                                            @NotNull String lastDateTime);
    
}
