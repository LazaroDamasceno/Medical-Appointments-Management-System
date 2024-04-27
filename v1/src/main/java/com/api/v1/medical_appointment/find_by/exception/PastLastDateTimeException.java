package com.api.v1.medical_appointment.find_by.exception;

public class PastLastDateTimeException  extends RuntimeException {

    public PastLastDateTimeException() {
        super("Last date time cannot be behind first time.");
    }
    
}
