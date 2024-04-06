package com.api.v1.physician.find_by_mln;

public class PhysicianNotFoundException extends  RuntimeException {

	private static final long serialVersionUID = 1L;

	public PhysicianNotFoundException(String mln) {
		super("Physician whose medical license number was not found.".formatted(mln));
	}
	
}
