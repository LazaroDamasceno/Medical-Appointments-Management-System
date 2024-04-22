package com.api.v1.physician.update;

import com.api.v1.auxiliary.PhysicianLicenseNumber;

import jakarta.validation.constraints.NotNull;

public interface UpdatePhysicianService {

    void update(@PhysicianLicenseNumber String physicianLicenseNumber, @NotNull UpdatePhysicianDTO dto);
    
}
