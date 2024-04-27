package com.api.v1.physician.helper;

public class PhysicianNotFoundException extends  RuntimeException {

	private static final long serialVersionUID = 1L;

	public PhysicianNotFoundException(String physicianLicenseNumber) {
		super("Physician whose medical license number is %s was not found.".formatted(physicianLicenseNumber));
	}
	
}
