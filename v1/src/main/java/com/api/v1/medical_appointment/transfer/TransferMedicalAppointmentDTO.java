package com.api.v1.medical_appointment.transfer;

import jakarta.validation.constraints.NotNull;

public record TransferMedicalAppointmentDTO(
    @NotNull
    String oldMedicalAppointmentDate,

    @NotNull
    String newMedicalAppointmentDate
) {
    
}
