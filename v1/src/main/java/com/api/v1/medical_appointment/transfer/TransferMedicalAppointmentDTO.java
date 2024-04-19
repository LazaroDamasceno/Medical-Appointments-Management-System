package com.api.v1.medical_appointment.transfer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TransferMedicalAppointmentDTO(
    @NotBlank
    @Size(min=7, max=7)
    String physicanLicenseNumber,

    @NotNull
    String oldMedicalAppointmentDate,

    @NotNull
    String newMedicalAppointmentDate
) {
    
}
