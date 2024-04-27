package com.api.v1.system_user;

import com.api.v1.auxiliary.customized_annotations.DateFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateSystemUserDTO(
    @NotBlank
    String fullName,
    
    @DateFormat
    String birthDate,
    
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
