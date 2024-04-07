package com.api.v1.system_user;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdatedSystemUserDTO(
    @NotNull 
    @Size(min = 7, max = 7) 
    String mln,

    @NotBlank
    String fullName,

    @NotNull
    Date birthDate,

    @NotBlank
    @Email
	String email,

    @NotNull
    @Size(min=7, max=7)
	String phoneNumber,

    @NotBlank
	String gender
) {
    
}
