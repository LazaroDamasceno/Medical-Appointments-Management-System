package com.api.v1.physician.hire;

import com.api.v1.system_user.RegisterSystemUserDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record HirePhysicianDTO(
		@NotNull
		@Size(min=7, max=7)
		String physicianLicenseNumber,
	
		@NotNull
		RegisterSystemUserDTO systemUserDTO
) {

}
