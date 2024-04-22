package com.api.v1.medical_appointment.transfer;

public class NewScheduledDateTimeException extends RuntimeException {

    public NewScheduledDateTimeException() {
        super("The new sheduled date time cannot be before or equals to the old scheduled date time.");
    }
    
}
