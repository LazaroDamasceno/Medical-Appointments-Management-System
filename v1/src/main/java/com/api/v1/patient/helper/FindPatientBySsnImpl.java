package com.api.v1.patient.helper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.v1.helper.customized_annotations.SSN;
import com.api.v1.patient.Patient;
import com.api.v1.patient.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindPatientBySsnImpl implements FindPatientBySsn {

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
