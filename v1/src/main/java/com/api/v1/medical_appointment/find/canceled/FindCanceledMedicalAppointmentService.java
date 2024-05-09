package com.api.v1.medical_appointment.find.canceled;

import java.util.List;

import com.api.v1.medical_appointment.MedicalAppointment;

public interface FindCanceledMedicalAppointmentService {
    
    List<MedicalAppointment> findByPatient(String ssn);

    List<MedicalAppointment> findByPhysician(String physicianLicenseNumber);

}
