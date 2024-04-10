package com.api.v1.patient.register;

import com.api.v1.system_user.RegisterSystemUserDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterPatientDTO(
		@NotBlank
		String address,
		
		@NotNull
		RegisterSystemUserDTO systemUser
) {

}
