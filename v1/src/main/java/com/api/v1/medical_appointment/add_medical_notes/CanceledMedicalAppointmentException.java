package com.api.v1.medical_appointment.add_medical_notes;

class CanceledMedicalAppointmentException extends RuntimeException {

    public CanceledMedicalAppointmentException() {
        super("Medical appointment's medical notes cannot be added because the medical appointment is canceled.");
    }
    
}
