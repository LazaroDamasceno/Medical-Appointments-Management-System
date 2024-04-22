package com.api.v1.medical_appointment.add_medical_notes;

import com.api.v1.auxiliary.PhysicianLicenseNumber;
import com.api.v1.auxiliary.SSN;

import jakarta.validation.constraints.NotNull;

public interface AddMedicalNotesService {
    
    void add(@SSN String ssn, @PhysicianLicenseNumber String physicianLicenseNumber, @NotNull String dateTime, @NotNull MedicalNotesDTO dto);

}
