package com.api.v1.medical_appointment.transfer;

import java.time.LocalDateTime;

import com.api.v1.helpers.PhysicianLicenseNumber;

public record TransferMedicalAppointmentDTO(
    @PhysicianLicenseNumber String physicianLicenseNumber, 
    LocalDateTime oldMedicalAppointmentDate,  
    LocalDateTime newMedicalAppointmentDate
) {
    
}
