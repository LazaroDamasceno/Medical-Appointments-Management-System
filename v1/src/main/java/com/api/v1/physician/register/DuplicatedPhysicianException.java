package com.api.v1.physician.register;

public class DuplicatedPhysicianException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DuplicatedPhysicianException(String mln) {
		super("Physician whose medical license number is %s is already persisted".formatted(mln));
	}

}
