package com.api.v1.medical_appointment.find_by.exception;

public class FutureFirstDateTimeException  extends RuntimeException {

    public FutureFirstDateTimeException() {
        super("First date time cannot be beyond last time.");
    }
    
}
