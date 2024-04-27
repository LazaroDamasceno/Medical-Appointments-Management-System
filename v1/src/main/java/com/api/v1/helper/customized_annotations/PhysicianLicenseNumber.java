package com.api.v1.helper.customized_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@NotNull
@Size(min = 7, max = 7)
public @interface PhysicianLicenseNumber {
    String message() default "Invalid Physician License Number format. Please enter a 7-digit Physician License Number.";
}
