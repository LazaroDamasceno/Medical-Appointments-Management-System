package com.api.v1.medical_appointment.cancel;

import jakarta.validation.constraints.NotNull;

interface CancelMedicalAppointmentService {
    
    void cancel(@NotNull CancelMedicalAppointmentDTO dto);

}
