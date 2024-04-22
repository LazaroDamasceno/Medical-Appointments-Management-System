package com.api.v1.patient.internal_use;

import com.api.v1.auxiliary.SSN;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindPatientBySsnService implements FindPatientBySsn {

	private final PatientRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Patient findBySsn(@SSN String ssn) {
		validateInput(ssn);
		return repository.findPatientBySsn(ssn);
	}
	
	private void validateInput(String ssn) {
		if (repository.findPatientBySsn(ssn) == null) {
			throw new PatientNotFoundException(ssn);
		}
	}

}
