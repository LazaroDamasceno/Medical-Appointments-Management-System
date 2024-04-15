package com.api.v1.medical_appointment.internal_user;

public class MedicalAppointmentNotFoundException extends RuntimeException {

    public MedicalAppointmentNotFoundException() {
        super("Wanted medical appointment was not found.");
    }
    
}
