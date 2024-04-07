package com.api.v1.patient.update;

import com.api.v1.system_user.UpdatedSystemUserDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdatePatientDTO(

    @NotBlank
    String address,

    @NotNull
    UpdatedSystemUserDTO systemUserDTO
) {

} 
