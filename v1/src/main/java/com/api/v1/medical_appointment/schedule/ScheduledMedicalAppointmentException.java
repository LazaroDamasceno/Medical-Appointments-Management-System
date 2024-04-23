package com.api.v1.medical_appointment.schedule;

public class ScheduledMedicalAppointmentException extends RuntimeException {

    public ScheduledMedicalAppointmentException(String dateTime) {
        super("The wanted date time %s is equals or before today's date. The scheduled date time must after today's date time".formatted(dateTime));
    }
    
}
