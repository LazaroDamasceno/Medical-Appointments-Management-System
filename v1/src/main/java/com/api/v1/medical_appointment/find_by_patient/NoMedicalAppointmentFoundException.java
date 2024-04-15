package com.api.v1.medical_appointment.find_by_patient;

public class NoMedicalAppointmentFoundException extends RuntimeException {

    public NoMedicalAppointmentFoundException() {
        super("No medical appointment was found.");
    }
    
}
