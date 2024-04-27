package com.api.v1.medical_appointment.transfer;

import com.api.v1.helper.customized_annotations.DateTimeFormat;
import com.api.v1.helper.customized_annotations.PhysicianLicenseNumber;

record TransferMedicalAppointmentDTO(
    @PhysicianLicenseNumber String physicianLicenseNumber, 
    @DateTimeFormat String oldMedicalAppointmentDate,  
    @DateTimeFormat String newMedicalAppointmentDate
) {
    
}
