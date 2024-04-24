package com.api.v1.patient.register;

class DuplicatedPatientException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DuplicatedPatientException(String ssn) {
		super("Patient whose ssn is %s is already persisted.".formatted(ssn));
	}
	

}
