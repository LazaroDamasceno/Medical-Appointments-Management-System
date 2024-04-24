package com.api.v1.medical_appointment.schedule;

class DuplicatedMedicalAppointmentException extends RuntimeException {

    public DuplicatedMedicalAppointmentException() {
        super("Medical appointment was aleady scheduled.");
    }
    
}
