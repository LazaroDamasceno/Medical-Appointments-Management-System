package com.api.v1.physician.update;

import com.api.v1.system_user.UpdateSystemUserDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdatePhysicianDTO(
    @NotNull
    @Size(min=7, max=7)
    String mln,

    @NotNull
    UpdateSystemUserDTO systemUserDTO
) {
    
}
