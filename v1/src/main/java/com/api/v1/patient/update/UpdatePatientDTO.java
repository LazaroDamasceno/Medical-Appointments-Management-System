package com.api.v1.patient.update;

import com.api.v1.auxiliary.customized_annotations.SSN;
import com.api.v1.system_user.UpdateSystemUserDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdatePatientDTO(
    @SSN String ssn,
    @NotBlank String address,
    @NotNull
    UpdateSystemUserDTO systemUserDTO
) {
    
}
