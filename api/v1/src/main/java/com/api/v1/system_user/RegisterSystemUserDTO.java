package com.api.v1.system_user;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterSystemUserDTO(
		@NotBlank
		String fullName,
		
		@NotNull
		@Size(min=9, max=9)
		String ssn,
		
		@NotNull
		Date birthDate,
		
		@NotBlank
		@Email
		String email,
		
		@NotNull
		@Size(min=10, max=10)
		String phoneNumber,
		
		@NotNull
		@Size(min=1)
		String gender
) { 

}
