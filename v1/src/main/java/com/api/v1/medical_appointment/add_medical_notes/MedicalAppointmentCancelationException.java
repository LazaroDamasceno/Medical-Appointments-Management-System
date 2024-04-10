package com.api.v1.medical_appointment.add_medical_notes;

public class MedicalAppointmentCancelationException extends RuntimeException {

    public MedicalAppointmentCancelationException() {
        super("Medical appointment's medical notes cannot be added because the medical appointment is canceled.");
    }
    
}
