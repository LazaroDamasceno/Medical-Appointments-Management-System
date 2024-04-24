package com.api.v1.medical_appointment.find_by.find_by_patient.finished;

import java.util.List;

import com.api.v1.auxiliary.DateTimeFormatForGET;
import com.api.v1.auxiliary.PhysicianLicenseNumber;
import com.api.v1.auxiliary.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;

public interface FindFinishedMedicalAppointmentsByPatientService {

    List<MedicalAppointment> findAll(@SSN String ssn);

    List<MedicalAppointment> find(@SSN String ssn, 
                                @DateTimeFormatForGET String firstDateTime, 
                                @DateTimeFormatForGET String lastDateTime
    );

    List<MedicalAppointment> findByPhysician(@SSN String ssn, 
                                            @PhysicianLicenseNumber String physicianLicenseNumber,
                                            @DateTimeFormatForGET String firstDateTime, 
                                            @DateTimeFormatForGET String lastDateTime);
    
}
