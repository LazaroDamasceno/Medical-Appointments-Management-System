package com.api.v1.medical_appointment.helper;

public class MedicalAppointmentNotFoundException extends RuntimeException {

    public MedicalAppointmentNotFoundException(String dateTime) {
        super("Wanted medical appointment whose date time is %s was not found.".formatted(dateTime));
    }
    
}
