package com.api.v1.medical_appointment.find_by.exception;

public class DateTimesEqualityException extends RuntimeException {

    public DateTimesEqualityException() {
        super("The date times cannot be equal.");
    }
    
}
