package com.api.v1.medical_appointment.find.scheduled;

import java.time.LocalDateTime;
import java.util.List;

import com.api.v1.medical_appointment.MedicalAppointment;

public interface FindScheduledMedicalAppointmentsService {

    List<MedicalAppointment> findByPatient(String ssn, LocalDateTime firstDateTime, LocalDateTime lastDateTime);

    List<MedicalAppointment> findByPhysicians(String physicianLicenseNumber, LocalDateTime firstDateTime, LocalDateTime lastDateTime);
    
}
