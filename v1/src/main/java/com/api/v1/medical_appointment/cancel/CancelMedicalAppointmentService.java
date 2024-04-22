package com.api.v1.medical_appointment.cancel;

import com.api.v1.auxiliary.SSN;

import jakarta.validation.constraints.NotNull;

public interface CancelMedicalAppointmentService {
    
    void cancel(@SSN String ssn, @NotNull String dateTime);

}
