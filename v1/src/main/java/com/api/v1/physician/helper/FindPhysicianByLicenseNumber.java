package com.api.v1.physician.helper;

import com.api.v1.helper.customized_annotations.PhysicianLicenseNumber;
import com.api.v1.physician.Physician;


public interface FindPhysicianByLicenseNumber {

	Physician findByphysicianLicenseNumber(@PhysicianLicenseNumber String physicianLicenseNumber);
	
}
