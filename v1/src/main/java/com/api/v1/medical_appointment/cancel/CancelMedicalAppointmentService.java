package com.api.v1.medical_appointment.cancel;

import jakarta.validation.constraints.NotNull;

public interface CancelMedicalAppointmentService {
    
    void cancel(@NotNull CancelMedicalAppointmentDTO dto);

}
