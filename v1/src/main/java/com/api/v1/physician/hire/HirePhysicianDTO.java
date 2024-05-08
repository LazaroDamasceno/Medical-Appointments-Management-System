package com.api.v1.physician.hire;

import com.api.v1.helpers.PhysicianLicenseNumber;
import com.api.v1.system_user.RegisterSystemUserDTO;

import jakarta.validation.constraints.NotNull;

public record HirePhysicianDTO(
		@PhysicianLicenseNumber
		String physicianLicenseNumber,
	
		@NotNull
		RegisterSystemUserDTO systemUserDTO
) {

}
