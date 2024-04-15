package com.api.v1.physician.internal_use;

import com.api.v1.physician.Physician;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public interface FindPhysicianByLicenseNumber {

	Physician findByPhysicanLicenseNumber(@NotNull @Size(min=7, max=7) String physicanLicenseNumber);
	
}
