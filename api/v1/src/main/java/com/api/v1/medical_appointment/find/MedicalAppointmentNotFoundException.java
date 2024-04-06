package com.api.v1.medical_appointment.find;

import java.util.Date;

import com.api.v1.patient.Patient;
import com.api.v1.physician.Physician;

public class MedicalAppointmentNotFoundException extends RuntimeException {

    public MedicalAppointmentNotFoundException(Patient patient, Physician physician, Date dateTime) {
        super("""
            Medical appointment whose patient's SSN is %s, physician's MLN iss %s and scheduled date is %s was not found.
        """.formatted(patient.getSystemUser().getSsn(), physician.getMln(), dateTime));
    }

    public MedicalAppointmentNotFoundException(Patient patient, Date dateTime) {
        super("""
            Medical appointment whose patient's SSN is %s and scheduled date is %s was not found.
        """.formatted(patient.getSystemUser().getSsn(), dateTime));
    }

    public MedicalAppointmentNotFoundException(Physician physician, Date dateTime) {
        super("""
            Medical appointment whose physician's MLN is %s and scheduled date is %s was not found.
        """.formatted(physician.getMln(), dateTime));
    }
    
}
