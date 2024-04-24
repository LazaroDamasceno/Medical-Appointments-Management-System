package com.api.v1.medical_appointment.transfer;

import com.api.v1.auxiliary.DateTimeFormat;
import com.api.v1.auxiliary.PhysicianLicenseNumber;


public record TransferMedicalAppointmentDTO(
    @PhysicianLicenseNumber String physicianLicenseNumber, 
    @DateTimeFormat String oldMedicalAppointmentDate,  
    @DateTimeFormat String newMedicalAppointmentDate
) {
    
}
