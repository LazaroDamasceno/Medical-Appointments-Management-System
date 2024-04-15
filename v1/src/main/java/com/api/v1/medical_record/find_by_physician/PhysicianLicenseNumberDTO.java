package com.api.v1.medical_record.find_by_physician;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PhysicianLicenseNumberDTO(
    @NotNull
    @Size(min=7, max=7)
    String physicianLicenseNumber
) {
    
}
