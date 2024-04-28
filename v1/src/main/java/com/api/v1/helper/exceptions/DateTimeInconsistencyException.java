package com.api.v1.helper.exceptions;

public class DateTimeInconsistencyException  extends RuntimeException {

    public DateTimeInconsistencyException() {
        super("First date time cannot be beyond last date time. Last date time cannot be behind the first date time.");
    }
    
}
