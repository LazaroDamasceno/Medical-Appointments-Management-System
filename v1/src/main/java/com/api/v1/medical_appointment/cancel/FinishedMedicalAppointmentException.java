package com.api.v1.medical_appointment.cancel;

public class FinishedMedicalAppointmentException extends RuntimeException {

    public FinishedMedicalAppointmentException() {
        super("Medical appointment cannot be canceled because it's finished.");
    }
    
}
