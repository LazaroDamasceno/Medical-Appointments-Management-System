package com.api.v1.helpers;

public class TemporalOrderException  extends RuntimeException {

    public TemporalOrderException() {
        super("First date time cannot be beyond last date time. Last date time cannot be behind the first date time.");
    }
    
}
