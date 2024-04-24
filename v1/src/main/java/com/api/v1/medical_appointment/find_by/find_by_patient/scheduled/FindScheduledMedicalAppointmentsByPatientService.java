package com.api.v1.medical_appointment.find_by.find_by_patient.scheduled;

import java.util.List;

import com.api.v1.auxiliary.DateTimeFormatForGET;
import com.api.v1.auxiliary.PhysicianLicenseNumber;
import com.api.v1.auxiliary.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindScheduledMedicalAppointmentsByPatientService {

    List<MedicalAppointment> find(@SSN String ssn, 
                            @DateTimeFormatForGET String firstDateTime, 
                            @DateTimeFormatForGET String lastDateTime);

    List<MedicalAppointment> findAll(@NotNull @Size(min=9, max=9) String ssn);

    List<MedicalAppointment> findByPhysician(@SSN String ssn, 
                                            @PhysicianLicenseNumber String physicianLicenseNumber,
                                            @DateTimeFormatForGET String firstDateTime, 
                                            @DateTimeFormatForGET String lastDateTime);
    
}
