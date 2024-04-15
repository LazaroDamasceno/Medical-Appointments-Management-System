package com.api.v1.medical_appointment.find_by;

public class MedicalAppointmentNotFoundException extends RuntimeException {

    public MedicalAppointmentNotFoundException() {
        super("Wanted medical appointment was not found.");
    }
    
}
