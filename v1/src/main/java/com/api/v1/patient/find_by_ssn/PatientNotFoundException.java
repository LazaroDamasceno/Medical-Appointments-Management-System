package com.api.v1.patient.find_by_ssn;

public class PatientNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PatientNotFoundException(String ssn) {
		super("Patient whose SSN is %s was not found.".formatted(ssn));
	}
	
}
