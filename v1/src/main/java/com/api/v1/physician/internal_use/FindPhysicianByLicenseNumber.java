package com.api.v1.physician.internal_use;

import com.api.v1.auxiliary.PhysicianLicenseNumber;
import com.api.v1.physician.Physician;


public interface FindPhysicianByLicenseNumber {

	Physician findByphysicianLicenseNumber(@PhysicianLicenseNumber String physicianLicenseNumber);
	
}
