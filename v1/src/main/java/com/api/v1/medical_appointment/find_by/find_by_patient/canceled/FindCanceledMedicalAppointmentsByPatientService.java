package com.api.v1.medical_appointment.find_by.find_by_patient.canceled;

import java.util.List;

import com.api.v1.helper.SSN;
import com.api.v1.medical_appointment.MedicalAppointment;

public interface FindCanceledMedicalAppointmentsByPatientService {

    List<MedicalAppointment> findAll(@SSN String ssn);
    
}
