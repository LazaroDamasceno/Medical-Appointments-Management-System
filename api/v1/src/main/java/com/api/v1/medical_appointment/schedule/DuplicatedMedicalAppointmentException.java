package com.api.v1.medical_appointment.schedule;

import java.util.Date;

public class DuplicatedMedicalAppointmentException extends RuntimeException {

    public DuplicatedMedicalAppointmentException(String ssn, String mln, Date dateTime) {
        super("""
            Medical appointment whose patient's SSN is %s, physician's MLN iss %s and scheduled date is %s is already scheduled.
        """.formatted(ssn, mln, dateTime));
    }
    
}
