package com.api.v1.medical_appointment.transfer;

import com.api.v1.auxiliary.PhysicianLicenseNumber;

import jakarta.validation.constraints.NotNull;

public record TransferMedicalAppointmentDTO(
    @PhysicianLicenseNumber String physicianLicenseNumber, 
    @NotNull String oldMedicalAppointmentDate,  
    @NotNull String newMedicalAppointmentDate
) {
    
}
