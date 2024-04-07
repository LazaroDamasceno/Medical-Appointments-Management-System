package com.api.v1.patient.update;

import com.api.v1.system_user.UpdatedSystemUserDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdatePatientDTO(
    @NotNull
    @Size(min=9, max=9)
    String ssn,

    @NotBlank
    String address,

    @NotNull
    UpdatedSystemUserDTO systemUserDTO
) {

} 
