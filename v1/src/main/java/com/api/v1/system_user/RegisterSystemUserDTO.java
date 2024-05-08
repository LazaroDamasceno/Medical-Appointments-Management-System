package com.api.v1.system_user;

import java.time.LocalDate;

import com.api.v1.helpers.SSN;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterSystemUserDTO(
		@NotBlank
		String fullName,
		
		@SSN
		String ssn,
		
		LocalDate birthDate,
		
		@NotBlank
		@Email
		String email,
		
		@NotNull
		@Size(min=10, max=10)
		String phoneNumber,
		
		@NotBlank
		String gender
) { 

}
