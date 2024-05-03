package com.api.v1.medical_appointment.transfer;

import com.api.v1.helper.DateTimeFormat;
import com.api.v1.helper.PhysicianLicenseNumber;

public record TransferMedicalAppointmentDTO(
    @PhysicianLicenseNumber String physicianLicenseNumber, 
    @DateTimeFormat String oldMedicalAppointmentDate,  
    @DateTimeFormat String newMedicalAppointmentDate
) {
    
}
