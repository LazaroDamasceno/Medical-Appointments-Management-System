package com.api.v1.physician.register;

import com.api.v1.system_user.RegisterSystemUserDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterPhysicianDTO(
		@NotBlank
		@Size(min=7, max=7)
		String mln,
	
		@NotNull
		RegisterSystemUserDTO systemUserDTO
) {

}
