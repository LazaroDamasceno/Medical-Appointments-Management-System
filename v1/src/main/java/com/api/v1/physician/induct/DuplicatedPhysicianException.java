package com.api.v1.physician.induct;

public class DuplicatedPhysicianException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DuplicatedPhysicianException(String physicianLicenseNumber) {
		super("Physician whose medical license number is %s is already persisted".formatted(physicianLicenseNumber));
	}

}
