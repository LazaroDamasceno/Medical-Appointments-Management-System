package com.api.v1.physician.helper;

import com.api.v1.helper.PhysicianLicenseNumber;
import com.api.v1.physician.Physician;

public interface FindPhysicianByLicenseNumber {

	Physician findByphysicianLicenseNumber(@PhysicianLicenseNumber String physicianLicenseNumber);
	
}
