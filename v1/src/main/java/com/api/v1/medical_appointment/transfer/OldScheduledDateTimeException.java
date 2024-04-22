package com.api.v1.medical_appointment.transfer;

public class OldScheduledDateTimeException extends RuntimeException {

    public OldScheduledDateTimeException() {
        super("The old sheduled date time cannot br after the new scheduled date time.");
    }
    
}
