package com.api.v1.medical_appointment.transfer;

import jakarta.validation.constraints.NotNull;

interface TransferMedicalAppointmentService {

    void transfer(@NotNull TransferMedicalAppointmentDTO dto);
        
}
