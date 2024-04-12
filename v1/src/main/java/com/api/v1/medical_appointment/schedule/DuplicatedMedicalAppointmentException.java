package com.api.v1.medical_appointment.schedule;

import java.time.LocalDateTime;

import com.api.v1.patient.Patient;
import com.api.v1.physician.Physician;

public class DuplicatedMedicalAppointmentException extends RuntimeException {

    public DuplicatedMedicalAppointmentException(Patient patient, Physician physician, LocalDateTime dateTime) {
        super("""
        Medical appointment whose patient's SSN is %s, physician's MLN iss %s and scheduled date is %s is already scheduled.
        """.formatted(patient.getSystemUser().getSsn(), physician.getMln(), dateTime));
    }
    
}
