package com.api.v1.physician.internal_use;

public class PhysicianNotFoundException extends  RuntimeException {

	private static final long serialVersionUID = 1L;

	public PhysicianNotFoundException(String physicanLicenseNumber) {
		super("Physician whose medical license number is %s was not found.".formatted(physicanLicenseNumber));
	}
	
}
