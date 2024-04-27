package com.api.v1.helper.exceptions;

public class PastLastDateTimeException  extends RuntimeException {

    public PastLastDateTimeException() {
        super("Last date time cannot be behind first time.");
    }
    
}
