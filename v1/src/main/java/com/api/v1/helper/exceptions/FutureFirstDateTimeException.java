package com.api.v1.helper.exceptions;

public class FutureFirstDateTimeException  extends RuntimeException {

    public FutureFirstDateTimeException() {
        super("First date time cannot be beyond last time.");
    }
    
}
