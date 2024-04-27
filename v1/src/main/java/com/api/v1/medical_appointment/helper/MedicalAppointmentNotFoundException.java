package com.api.v1.medical_appointment.helper;

public class MedicalAppointmentNotFoundException extends RuntimeException {

    public MedicalAppointmentNotFoundException() {
        super("Wanted medical appointment was not found.");
    }
    
}
