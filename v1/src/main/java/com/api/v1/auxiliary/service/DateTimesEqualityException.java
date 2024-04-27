package com.api.v1.auxiliary.service;

public class DateTimesEqualityException extends RuntimeException {

    public DateTimesEqualityException() {
        super("First date time annot be equals to the last date time.");
    }
    
}
