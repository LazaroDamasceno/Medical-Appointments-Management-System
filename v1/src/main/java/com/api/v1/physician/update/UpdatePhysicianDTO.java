package com.api.v1.physician.update;

import com.api.v1.helper.customized_annotations.PhysicianLicenseNumber;
import com.api.v1.system_user.UpdateSystemUserDTO;

import jakarta.validation.constraints.NotNull;

public record UpdatePhysicianDTO(
    @PhysicianLicenseNumber String physicianLicenseNumber,
    @NotNull UpdateSystemUserDTO systemUserDTO
) {
    
}
