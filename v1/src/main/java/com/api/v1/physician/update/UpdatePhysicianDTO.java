package com.api.v1.physician.update;

import com.api.v1.system_user.UpdateSystemUserDTO;

import jakarta.validation.constraints.NotNull;

public record UpdatePhysicianDTO(
    @NotNull
    UpdateSystemUserDTO systemUserDTO
) {
    
}
