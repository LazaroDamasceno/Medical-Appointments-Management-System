package com.api.v1.helper.exceptions;

public class DateTimesEqualityException extends RuntimeException {

    public DateTimesEqualityException() {
        super("The date times cannot be equal.");
    }
    
}
