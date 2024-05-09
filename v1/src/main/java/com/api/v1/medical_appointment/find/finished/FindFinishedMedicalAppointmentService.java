package com.api.v1.medical_appointment.find.finished;

import java.time.LocalDateTime;
import java.util.List;

import com.api.v1.medical_appointment.MedicalAppointment;

public interface FindFinishedMedicalAppointmentService {
    
    List<MedicalAppointment> findByPatient(String ssn, LocalDateTime firstDateTime, LocalDateTime lastDateTime);

    List<MedicalAppointment> findByPhysicain(String physicianLicenseNumber, LocalDateTime firstDateTime, LocalDateTime lastDateTime);

}
