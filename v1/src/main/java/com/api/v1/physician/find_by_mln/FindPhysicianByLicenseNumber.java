package com.api.v1.physician.find_by_mln;

import com.api.v1.physician.Physician;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindPhysicianByLicenseNumber {

	Physician findByphysicanLicenseNumber(@NotNull @Size(min=9, max=9) String physicanLicenseNumber);
	
}